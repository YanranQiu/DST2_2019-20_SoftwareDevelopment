$(function() {
    //显示隐藏的文件名并上传状态切换
    $('.showFileName').hide();
    $('#uploadBtn').hide();
    $("#upload").on("change", "input[type='file']", function() {
        var filePath = $(this).val();
        if(filePath) {
            $(".fileerrorTip").html("").hide();
            var arr = filePath.split('\\');
            var fileName = arr[arr.length - 1];
            $('.showFileName').show();
            $('#uploadBtn').show();
            $(".showFileName").html("VCF file：" + fileName);
            $('#upload').hide();
        } else {
            $(".showFileName").html("");
            $(".fileerrorTip").html("You did not upload the file, or you upload the file type is wrong!").show();
            return false
        }
    });

});