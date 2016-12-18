import { Component, Lifecycle, Prop, Vue } from "av-ts"
import addTask, { Task } from "./module/addTask"
import TaskInput from "./TaskInput"

interface TaskNode {
  id: number
  name: string
  children?: TaskNode[]
}
@Component({
  name: "tree",
  components: { "task-input": TaskInput },
  ...require("./tree.html"),
})
class Tree extends Vue {
  open = false
  name = ""
  isFolder = false
  @Prop model: TaskNode
  @Lifecycle mounted() {
    this.isFolder = this.model.children != null && this.model.children.length > 0
  }
  toggleFolder() {
    this.open = !this.open
  }
  changeFolder() {
    if (!this.isFolder) {
      Vue.set(this.model, "children", [])
      this.isFolder = true
      this.open = true
    }
  }
  addTask(task: Task) {
    task.parent = this.model.id
    addTask(task).then((taskRes) => {
      this.model.children!.push(taskRes)
    })
  }
}

export default Tree