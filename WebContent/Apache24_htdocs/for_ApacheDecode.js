/**
 * put this page to Apache24/htdocs/for_ApacheDecode.js by hand copy-paste
 */


function getUrlQuery(){
    var queryStr = window.location.search.substring(1);
    var queryArray = [];

    if (queryStr){
        var division = queryStr.split('&');

        for (i = 0; i < division.length; i++){
            var reDivision = division[i].split('=');
            queryArray[reDivision[0]] = reDivision[1];
        }//for i

    } else if (!queryStr) {
        queryArray['name'] = "";
        queryArray['pass'] = "";
        queryArray['mail'] = "";
    }//if

    return queryArray;

}//function getUrlQuery()


function decodeName(nameCode){
    var nameDecode = '';
    var division = nameCode.split('%');
    for ( i = 0; i < division.length; i++){
        nameDecode += String.fromCharCode(division[i].replace('n', '0x'));
    }
    return nameDecode;
}//function decodeName()

function decodeMail(mailCode){
  var mailDecode = '';
    var division = mailCode.split('%');
    for ( i = 0; i < division.length; i++){
        mailDecode += String.fromCharCode(division[i].replace('m', '0x'));
    }
    return mailDecode;
}//function decodeMail()


/*
// ====== Net Referense ======
◆JavaScript逆引き
＊Unicode（¥uxxx形式）を文字列へアンエスケープ
https://shanabrian.com/web/javascript/unicode-unescape.php

var unicodeUnescape = function(str) {
    var result = '', strs = str.match(/\\u.{4}/ig);
    if (!strs) return '';
    for (var i = 0, len = strs.length; i < len; i++) {
        result += String.fromCharCode(strs[i].replace('\\u', '0x'));
    }
    return result;
};

// ====== Net Refernse ======
◆JavaScriptまとめ
＊Unicode Tester
http://cya.sakura.ne.jp/js/escape.htm


*/