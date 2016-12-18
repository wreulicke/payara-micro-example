
import { Component, Lifecycle, Prop, Vue } from "av-ts"

@Component({
  name: "taskInput",
  ...require("./taskInput.html"),
})
class TaskInput extends Vue {
  mode = ""
  name = ""
  @Prop add: Function
  toAdd() {
    this.mode = "add"
  }
  toInit() {
    this.mode = ""
    this.name = ""
  }
  _add() {
    const input = { name: this.name }
    this.add(input)
  }
  @Lifecycle updated() {
    if (this.isAddMode) {
      const taskName = (this.$refs as any).taskName as HTMLElement
      taskName.focus()
    }
  }
  get isAddMode() {
    return this.mode === "add"
  }
}

export default TaskInput