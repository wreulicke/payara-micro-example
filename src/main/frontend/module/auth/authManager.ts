import * as emitter from "eventemitter2"
import { login } from "./login"
class Manager extends emitter.EventEmitter2 {
  login(name: string, password: string) {
    return login({ name, password })
      .then(() => {
        this.emit("logined")
      })
  }
}

const manager = new Manager()
export default manager
