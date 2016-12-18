import { Component, Prop, Vue } from "av-ts"
import addTask, { Task } from "./module/addTask"

interface TreeObject {
  name: string
  children?: TreeObject[]
}
@Component({
  name: "tree",
  ...require("./tree.html"),
})
class Tree extends Vue {
  open = false
  name = ""
  @Prop model: TreeObject
  get isFolder() {
    return this.model.children && this.model.children.length > 0
  }
  toggleFolder() {
    this.open = !this.open
  }
  addTask(task: Task) {
    addTask(task).then((taskRes) => {
      if (this.model.children != null) {
        this.model.children = this.model.children.concat(taskRes)
      }
    })
  }
}

export default Tree