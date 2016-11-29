var rootPath = "/loan";
/*
 * 刷新验证码
 */
function reflushImg(imgCode)
{
	/* 获得对象 */
	var dom = $("#"+imgCode);
	dom.attr("src",rootPath+"/code.htm?new="+new Date());
	return false;
}