import App from "./app"
import createTree from "./createTree"
import tasks from "./tasks"
import Tree from "./tree"

const init = () => {
  new App().$mount("#app")
  new Tree({
    propsData: {
      model: createTree(tasks)[0],
    },
  }).$mount("#tree")
}
document.addEventListener("DOMContentLoaded", init)