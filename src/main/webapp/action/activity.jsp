<%--
  Created by IntelliJ IDEA.
  User: deii66
  Date: 2017/11/8
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<html>
<head>
    <title>活动</title>
    <script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="../assets/css/bootstrap.css" rel='stylesheet' type='text/css' />

    <script src="../assets/js/jquery-2.1.1.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <!-- animation-effect -->
    <link href="../assets/css/animate.min.css" rel="stylesheet">
    <link href="../assets/css/participateStyle.css" rel="stylesheet">
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/css/stickup.css" rel="stylesheet">
    <link href="../assets/css/button.css" rel="stylesheet">
    <script src="../assets/js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>

</head>
<body>

<div class="navbar-wrapper" id="animenu">

    <nav class="animenu">
        <button class="animenu__toggle">
            <span class="animenu__toggle__bar"></span>
            <span class="animenu__toggle__bar"></span>
            <span class="animenu__toggle__bar"></span>
        </button>

        <ul class="animenu__nav">
            <li><img src="../assets/img/logo.jpg"></li>
            <li>
                <a href="../index.jsp">首页</a>
            </li>
            <li>
                <a href="../hotspot/hotspot-index.jsp">热点</a>
            </li>
            <li>
                <a href="#">在行动</a>
                <ul class="animenu__nav__child">
                    <li><a href="caiyun-index.jsp">彩云之南</a></li>
                    <li><a href="chunhui-index.jsp">春晖之声</a></li>
                    <li><a href="cat-index.jsp">宠物之家</a></li>
                </ul>
            </li>
            <li>
                <a href="../participate/participate-index.jsp">在参与</a>
            </li>
            <button onclick="window.location='../Login/regist.jsp'" class="button button-normal button-plain button-border button-square" style="float: right;margin: 5px 10px 10px;">注册</button>
            <button onclick="window.location='../login.jsp'" class="button button-normal button-plain button-border button-square" style="float: right;margin: 5px 5px 10px;">登录</button>
        </ul>
    </nav>
    <!-- End Navbar -->
</div> <!-- END NAVBAR -->
<div class="banner two">
</div>
<!--start-news-->
<div class="news two">
    <div class="container">
        <h3 class="tittle">活动</h3>
        <div class="news-article">
            <div class="article-post">
                <img style="width: 1100px;height: 500px" src="../assets/img/chunhui-participate.jpg"/>
                <div class="col-md-3 post-meta">
                    <div class="meta-icon">
                        <div class="pic">
                            <a href="#" > <i class="glyphicon glyphicon-picture"></i></a>
                        </div>
                    </div>
                    <ul class="ad-info">
                        <li>21 Aug'15</li>
                        <li> <a href="#">John Doe</a></li>
                        <li> <a href="#">24 Comments</a></li>
                    </ul>
                    <div class="clearfix"> </div>
                </div>
                <div class="col-md-9 post-details">
                    <h3>To Protect Humanity</h3>
                    <p>Nam nec tellus a odio tincidunt auctor a ornare odio.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus porta. Fusce suscipit varius mi. nascetur ridiculus mus. Nulla dui. Fusce feugiat malesuada odio. Morbi nunc odio, gravida at, cursus nec, luctus a, lorem. Maecenas tristique orci ac sem. Duis ultricies pharetra magna in 2001 donec accumsan malesuada orci. Donec sit amet eros.  Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo.</p>
                </div>
                <!--post-details-->
                <div class="clearfix"> </div>


                <div class="col-md-10 data">
                    <h5 class="m_26" style="float: left;width: 100px;text-align: center;font-size: 18px;"> <a href="donate.jsp"> 捐 款 </a></h5>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <div class="single">
            <div class="leave">
                <h4>留 下 评 论</h4>
            </div>
            <form id="commentform">
                    <textarea style="width: 1000px"></textarea>
                <div class="clearfix"></div>
                <p class="form-submit">
                    <input name="submit" type="submit" id="submit" value="评论">
                </p>
                <div class="clearfix"></div>
            </form>
            <div class="single_grid2">
                <h4 class="tz-title-4 tzcolor-blue">
                    其他人的评论
                </h4>
                <ul class="list">
                    <li>
                        <div class="col-md-2 preview"><a href="#"><img src="../assets/img/co.png" class="img-responsive" alt=""></a></div>
                        <div class="col-md-10 data">
                            <div class="title"><a href="#">donator</a><br><span class="m_14">Aug 30, 2015</span></div>
                            <p>Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature</p>
                            <h5 class="m_26"> <a href="#">回复</a></h5>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    <li>
                        <div class="col-md-2 preview"><a href="#"><img src="../assets/img/co.png" class="img-responsive" alt=""></a></div>
                        <div class="col-md-10 data">
                            <div class="title"><a href="#">donator</a><br><span class="m_14">Sep 2, 2015</span></div>
                            <p>Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature</p>
                            <h5 class="m_26"> <a href="#">回复</a></h5>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    <li>
                        <div class="col-md-2 preview"><a href="#"><img src="../assets/img/co.png" class="img-responsive" alt=""></a></div>
                        <div class="col-md-10 data">
                            <div class="title"><a href="#">donator</a><br><span class="m_14">Nov 2, 2015</span></div>
                            <p>Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature</p>
                            <h5 class="m_26"> <a href="#">回复</a></h5>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--start-smoth-scrolling-->
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!--start-smoth-scrolling-->
<script type="text/javascript">
    $(document).ready(function() {
        /*
        var defaults = {
              containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
         };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#animenu" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

</body>
</html>
