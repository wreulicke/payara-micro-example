import App from "./app"
import Task from "./task"
const init = () => {
  new App().$mount("#app")
  new Task().$mount("#tree")
}
document.addEventListener("DOMContentLoaded", init)