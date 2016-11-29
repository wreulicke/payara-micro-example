import * as Vue from "vue";

document.addEventListener('DOMContentLoaded',()=>{
  new Vue({
      el: '#app',
      render(h) {
          return h('h1', 'hello world')
      }
  })
})
