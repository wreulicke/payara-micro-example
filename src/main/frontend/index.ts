import * as Vue from "vue"

const {render, staticRenderFns} = require("./test.html")

document.addEventListener("DOMContentLoaded", () => {
    new Vue({
        name: "app",
        data() {
            return {
                name: "",
                password: "",
                myName: "",
            }
        },
        methods: {
            login() {
                const data = this as any
                fetch("http://localhost:8080/api/example/login", {
                    method: "POST",
                    headers: {
                        "content-type": "application/json",
                    },
                    credentials: "include",
                    body: JSON.stringify({
                        name: data.name,
                        password: data.password,
                    }),
                }).then((r) => r.json(), console.log.bind(console))
                    .then((json: any) => {
                        data.myName = json.name
                    })
            },
        },
        render,
        staticRenderFns,
    }).$mount("#app")
})