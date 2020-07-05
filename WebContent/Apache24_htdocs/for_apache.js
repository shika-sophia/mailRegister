/**
 *for Apache/htdocs/index.html
 */
/*
function getUrlQuery() {
  var queryStr = window.location.search.slice(1);  // 文頭?を除外
      query = {};

  // クエリがない場合は空のオブジェクトを返す
  if (!queryStr) {
    return query;
  }

  // クエリ文字列を & で分割して処理
  queryStr.split('&').forEach(function(queryStr) {
    // = で分割してkey,valueをオブジェクトに格納
    var queryArray = queryStr.split('=');
    query[queryArray[0]] = queryArray[1];
  });
  return query;
}//function
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

