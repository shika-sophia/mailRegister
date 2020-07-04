/**
 *for Apache/htdocs/index.html
 */

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
}