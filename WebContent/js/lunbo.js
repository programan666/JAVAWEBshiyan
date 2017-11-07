var arrowRight = $('.banner .arrow-right');
var arrowLeft = $('.banner .arrow-left');
var imgs = $('.banner .imgs img');
var circles = $('.banner .circle-item');
var i = 0;
arrowRight.click(function(){
	i++;
	i %= 5;
	move();
});
arrowLeft.click(function(){
	i--;
	if(i == -1){
		i = 4;
	}
	move();
});
var timer = setInterval(function(){
	i++;
	i %= 5;
	move();
},2000);

function move(){
	/*
	 * eq() 根据下标在imgs（多张图片）中找到某一张图片
	 * show() 显示 相当于设置 display:block;
	 * hide() 隐藏 相当于设置 display:none;
	 * siblings() 同一个盒子中同层级的其他兄弟（比如imgs 里面的img）
	 * addClass() 给元素添加一个class样式
	 * removeClass() 给元素去掉一个class样式
	 */
	imgs.removeClass('active');
	imgs.eq(i).addClass('active');
	circles.removeClass('active');
	circles.eq(i).addClass('active');
}
/*
 * hover 当鼠标移入和移出的时候要做的事情
 * .hover(fn1,fn2);
 * fn1 鼠标移入要做的事情
 * fn2 鼠标移出要做的事情
 */
$('.c-b-left .banner').hover(function(){
	/*清除定时器*/
	clearInterval(timer);
},function(){
	/*重新添加定时器*/
	timer = setInterval(function(){
		i++;
		i %= 5;
		move();
	},2000);
});
circles.hover(function(){
	/*鼠标经过小圆圈的索引值*/
	i=$(this).index();
	move();
});

