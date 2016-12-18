import App from "./app"
import createTree from "./createTree"
import Task from "./task"
import tasks from "./tasks"
const init = () => {
  new App().$mount("#app")
  new Task({ propsData: { roots: createTree(tasks) } }).$mount("#tree")
}
document.addEventListener("DOMContentLoaded", init)