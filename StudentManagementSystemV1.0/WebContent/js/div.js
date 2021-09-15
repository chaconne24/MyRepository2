/**
 * 可移动的DIV的JS代码
 */
var mouseX, mouseY; // 鼠标x坐标和y坐标
var objX, objY; 
var isDowm = false; // 标识是否已按下鼠标 
/**
* @param obj div 对象 e 事件对象(Mouse)
*/
function mouseDown(obj, e) { 
	obj.style.cursor = "move"; // 鼠标在div上按下时光标样式
	/* 记录div和鼠标坐标*/
	objX = div1.style.left; 
	objY = div1.style.top; 
	mouseX = e.clientX; 
	mouseY = e.clientY; 
	isDowm = true; // 标识为鼠标按下
} 
/**
* 鼠标移动
*/
function mouseMove(e) { 
	var div = document.getElementById("div1"); 
	var x = e.clientX; 
	var y = e.clientY; 
	if (isDowm) { 
		div.style.left = parseInt(objX) + parseInt(x) - parseInt(mouseX) + "px"; 
		div.style.top = parseInt(objY) + parseInt(y) - parseInt(mouseY) + "px"; 
	} 
} 
function mouseUp(e) { 
	if (isDowm) { 
		var x = e.clientX; 
		var y = e.clientY; 
		var div = document.getElementById("div1"); 
		div.style.left = (parseInt(x) - parseInt(mouseX) + parseInt(objX)) + "px"; 
		div.style.top = (parseInt(y) - parseInt(mouseY) + parseInt(objY)) + "px"; 
		mouseX = x; 
		rewmouseY = y; 
		div1.style.cursor = "default"; 
		isDowm = false; 
	} 
} 