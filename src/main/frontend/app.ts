import { Component, Vue } from "av-ts"
import manager from "./module/auth/authManager"
import { LoginInfo } from "./module/auth/login"
const template = require("./app.html")

@Component({
  name: "app",
  ...template,
})
class App extends Vue implements LoginInfo {
  name = ""
  password = ""
  logined = false
  login() {
    manager.login(this.name, this.password).then(() => {
      this.logined = true
    })
  }
}

export default App