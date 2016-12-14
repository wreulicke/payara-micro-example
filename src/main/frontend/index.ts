import App from "./app"
import Tree from "./tree"

const creatTree = (tasks: any) => {
  const res = {} as any
  tasks.forEach((task: any) => {
    if (res[task.id] == null) {
      res[task.id] = { id: task.id }
    }
    const ref = res[task.id]
    ref.name = task.name
    ref.parent = task.parent
    if (task.parent != null) {
      if (res[task.parent] == null) {
        res[task.parent] = { id: task.parent }
      }
      const parent = res[task.parent]
      parent.children = (parent.children || []).concat(ref)
    }
  })
  return Object.keys(res).reduce((r, key) =>
    (res[key].parent == null) ? r.concat(res[key]) : r
    , [])
}
const tasks = [
  {
    id: 1,
    name: "My Tree",
  },
  {
    name: "hello",
    id: 2,
    parent: 1,
  },
  {
    name: "wat",
    id: 3,
    parent: 1,
  },
  {
    id: 4,
    name: "child folder",
    parent: 1,
  },
  {
    id: 5,
    name: "child folder",
    parent: 4,
  },
  {
    name: "hello",
    id: 6,
    parent: 5,
  },
  {
    name: "wat",
    id: 7,
    parent: 5,
  },
  {
    name: "hello",
    id: 8,
    parent: 4,
  },
  {
    name: "wat",
    id: 9,
    parent: 4,
  },
  {
    id: 10,
    name: "child folder",
    parent: 4,
  },
  {
    name: "hello",
    id: 11,
    parent: 10,
  },
  {
    name: "wat",
    id: 12,
    parent: 10,
  },
]
const init = () => {
  new App().$mount("#app")
  new Tree({
    propsData: {
      model: creatTree(tasks)[0],
    },
  }).$mount("#tree")
}
document.addEventListener("DOMContentLoaded", init)