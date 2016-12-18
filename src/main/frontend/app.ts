import { Component, Vue } from "av-ts"
import { login, LoginInfo } from "./module/auth/login"
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
    login({
      name: this.name,
      password: this.password,
    }).then(_ => {
      this.logined = true
    })
  }
}

export default App