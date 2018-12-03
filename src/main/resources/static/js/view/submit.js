$(function () {
    /*提交验证*/
    $("#submit-btn").click(function () {
        /*姓名不能为空*/
        if ($("#name").val() == '') {
            $('#name').focus();
            layer.open({
                content: '姓名不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*年龄正则验证*/
        if (!(/^[0-9]*[1-9][0-9]*$/).test($("#age").val())) {
            $('#age').focus();
            layer.open({
                content: '年龄不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*手机号正则验证*/
        if (!(/^1(3|4|5|7|8)[0-9]{9}$/).test($("#phone").val())) {
            $('#phone').focus();
            layer.open({
                content: '手机号输入有误',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        if ($("#wechat").val() == '') {
            $('#wechat').focus();
            layer.open({
                content: '姓名不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*芝麻分验证*/
        if (!(/^[0-9]*[1-9][0-9]*$/).test($("#score").val())) {
            $('#score').focus();
            layer.open({
                content: '芝麻分不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*银行卡号验证*/
        if (!(/^[0-9]*[1-9][0-9]*$/).test($("#bankNum").val())) {
            $('#bankNum').focus();
            layer.open({
                content: '银行卡号不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*银行验证*/
        if ($("#bank").val() == '') {
            $('#bank').focus();
            layer.open({
                content: '所属银行不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*身份证号*/
        // if (!(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/).test($("#card").val())) {
        //     $('#card').focus();
        //     layer.open({
        //         content: '身份证号格式错误',
        //         skin: 'msg',
        //         time: 2 /*2秒后自动关闭*/
        //     });
        //     return false;
        // }
        /*现住地址*/

        if($('#card').val() == ''){
            $('#card').focus();
            layer.open({
                content: '身份证号不能为空',
                skin: 'msg',
                time: 2
            });
            return false;
        }

        if ($("#address").val() == '') {
            $('#address').focus();
            layer.open({
                content: '地址不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*配偶*/
        if ($("#wife").val() == '') {
            $('#wife').focus();
            layer.open({
                content: '配偶不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*配偶手机号正则验证*/
        if (!(/^1(3|4|5|7|8)[0-9]{9}$/).test($("#wifePhone").val())) {
            $('#wifePhone').focus();
            layer.open({
                content: '配偶手机号输入有误',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*父亲*/
        if ($("#father").val() == '') {
            $('#father').focus();
            layer.open({
                content: '父亲不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*父亲手机号正则验证*/
        if (!(/^1(3|4|5|7|8)[0-9]{9}$/).test($("#fatherPhone").val())) {
            $('#fatherPhone').focus();
            layer.open({
                content: '父亲手机号输入有误',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*母亲*/
        if ($("#mother").val() == '') {
            $('#mother').focus();
            layer.open({
                content: '母亲不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*母亲手机号正则验证*/
        if (!(/^1(3|4|5|7|8)[0-9]{9}$/).test($("#motherPhone").val())) {
            $('#motherPhone').focus();
            layer.open({
                content: '母亲手机号输入有误',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*同事*/
        if ($("#friend").val() == '') {
            $('#friend').focus();
            layer.open({
                content: '同事不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*同事手机号正则验证*/
        if (!(/^1(3|4|5|7|8)[0-9]{9}$/).test($("#friendPhone").val())) {
            $('#friendPhone').focus();
            layer.open({
                content: '同事手机号输入有误',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*朋友*/
        if ($("#workmate").val() == '') {
            $('#workmate').focus();
            layer.open({
                content: '朋友不能为空',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        /*父亲手机号正则验证*/
        if (!(/^1(3|4|5|7|8)[0-9]{9}$/).test($("#workmatePhone").val())) {
            $('#workmatePhone').focus();
            layer.open({
                content: '朋友手机号输入有误',
                skin: 'msg',
                time: 2 /*2秒后自动关闭*/
            });
            return false;
        }
        fn_loginin();
    });
})
/*登录按钮请求服务器*/
function fn_loginin() {
    /*请求服务端*/
    $.ajax({
        url:"/addUser",
        type: "post",
        dataType: 'json',
        // jsonp: 'callback',
        data: {
            "name":$('#name').val(),
            "age":$('#age').val(),
            "phone":$('#phone').val(),
            "wechat":$('#wechat').val(),
            "score":$('#score').val(),
            "bankNum":$('#bankNum').val(), /*银行卡号*/
            "bank":$('#bank').val(),//所属银行
            "card":$('#card').val(),
            "address":$('#address').val(),
            "wife":$('#wife').val(),
            "wifePhone":$('#wifePhone').val(),
            "father":$('#father').val(),
            "fatherPhone":$('#fatherPhone').val(),
            "mother":$('#mother').val(),
            "motherPhone":$('#motherPhone').val(),
            "workmate":$('#workmate').val(),
            "workmatePhone":$('#workmatePhone').val(),
            "friend":$('#friend').val(),
            "friendPhone":$('#friendPhone').val(),
            "workUnit":$('#workUnit').val(),
            "workmate":$('#workmate').val(),
            "work":$('#work').val(),
            "unitPhone":$('#unitPhone').val(),
            "workAddress":$('#workAddress').val(),
            "socialSecurity":$('#socialSecurity').val()
        },
        success: function (rel_data) {
            if (rel_data.data == 1) {
                layer.open({
                    content: '提交成功',
                    skin: 'msg',
                    time: 2 /*2秒后自动关闭*/
                });
                window.location.href="notice";
            } else {
                layer.open({
                    content: rel_data.msg,
                    skin: 'msg',
                    time: 5 /*2秒后自动关闭*/
                });
            }

        }
    });
}