/**
 * 自己封装的一些 通用的js 语句
 * @type {{}}
 */

common = {};

//Demo
common.back = function () {
    layui.use('form', function () {
        var form = layui.form;

        //监听 返回上一页
        // form.on('submit(formSave)', function (data) {
        //     if (validateForm.form()) {
        //         saveOrUpdate();
        //     }
        // });
        form.on('submit(formCancel)', function () {
            history.back(-1);
        })
    });
};
