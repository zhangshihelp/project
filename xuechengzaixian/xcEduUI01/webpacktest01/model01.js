var add = function (x, y) {
    return x + y;
};
var plus = function (x, y) {
    return x * y;
};

module.exports.add = add;
// module.exports.plus = plus;
// 多个方法导出
// module.exports = {add, plus};