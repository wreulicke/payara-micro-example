import { Component, Prop, Vue } from "av-ts"
import addTask, { Task as ITask } from "./module/addTask"
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
  @Prop roots: TreeObject[]
  addTask(task: ITask) {
    addTask(task).then(() => {
      this.roots = this.roots.concat(task)
    })
  }
}

export default Task