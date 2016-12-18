export interface Task {
  id: number
  name: string
  parent?: number
}

export interface TaskNode extends Task {
  children?: TaskNode[]
}

type TaskRepository = { [id: string]: TaskNode }


const createTreeInternal = (tree: TaskRepository, task: Task) => {
  const ref = tree[task.id] = {
    ...tree[task.id],
    id: task.id,
    name: task.name,
    parent: task.parent,
  }
  if (task.parent != null) {
    const parent = tree[task.parent] = tree[task.parent] || { id: task.parent }
    parent.children = (parent.children || []).concat(ref)
  }
  return tree
}

const createTree = (tasks: Task[]) => {
  const result = tasks.reduce(createTreeInternal, {})
  return Object.keys(result).map((key) => result[key]).filter((task) => task.parent == null)
}

export default createTree