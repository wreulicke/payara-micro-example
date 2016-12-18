import { Component, Lifecycle, Vue } from "av-ts"
import createTree, { Task as ITask } from "./createTree"
import addTask from "./module/addTask"
import manager from "./module/auth/authManager"
import tasks from "./module/task"
import TaskInput from "./TaskInput"
import tree from "./tree"


interface TreeObject {
  name: string
  children?: TreeObject[]
}

@Component({
  name: "task",
  components: { tree, "task-input": TaskInput },
  ...require("./task.html"),
})
class Task extends Vue {
  roots: TreeObject[] = []
  @Lifecycle mounted() {
    tasks().then((response: ITask[]) => {
      this.roots = createTree(response)
    })
    manager.on("logined", () => {
      tasks().then((response: ITask[]) => {
        this.roots = createTree(response)
      })
    })
  }
  addTask(task: ITask) {
    addTask(task).then((taskRes: ITask) => {
      this.roots = this.roots.concat(taskRes)
    })
  }
}

export default Task