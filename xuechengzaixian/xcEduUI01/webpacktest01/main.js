// 导入model01.js
var {add} = require("./model01");

// 导入vue.min的js文件
var Vue = require("./vue.min");

// 编写MVVM中的model部分及VM(ViewModel)部分
var VM = new Vue({
    el: '#app', // VM接管了app区域的管理
    data: {
        name: '张诗',
        num1: 0,
        num2: 0,
        result: 0,
        url: 'https://www.baidu.com',
        size: 33,
    },
    methods: {
        change: function () {
            this.result = add(Number.parseInt(this.num1), Number.parseInt(this.num2));
        }
    }
});