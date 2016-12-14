import { Component, Prop, Vue } from "av-ts"

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
  @Prop model: TreeObject
  get isFolder() {
    return this.model.children && this.model.children.length > 0
  }
  toggleFolder() {
    this.open = !this.open
  }
}

export default Tree