<%--
  Created by IntelliJ IDEA.
  User: deii66
  Date: 2017/11/13
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<html>
<head>
    <title>Creative Resume a Personal  Category Flat Bootstrap responsive Website Template | Home :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Creative Resume Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!--// bootstrap-css -->
    <!-- css -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!--// css -->
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css" media="all">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/cm-overlay.css" />
    <!-- font-awesome icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->

    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <!-- menu -->
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="../assets/css/button.css">
    <style type="text/css">
        button {
            cursor: pointer;
            width: 300px;
            height: 44px;
            margin-top: 25px;
            padding: 0;
            background: #ef4300;
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            border: 1px solid #ff730e;
            -moz-box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.25) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            -webkit-box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.25) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.25) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            font-family: 'PT Sans', Helvetica, Arial, sans-serif;
            font-size: 14px;
            font-weight: 700;
            color: #fff;
            text-shadow: 0 1px 2px rgba(0,0,0,.1);
            -o-transition: all .2s;
            -moz-transition: all .2s;
            -webkit-transition: all .2s;
            -ms-transition: all .2s;
        }

        button:hover {
            -moz-box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.15) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            -webkit-box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.15) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.15) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
        }

        button:active {
            -moz-box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.15) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            -webkit-box-shadow:
                    0 15px 30px 0 rgba(255,255,255,.15) inset,
                    0 2px 7px 0 rgba(0,0,0,.2);
            box-shadow:
                    0 5px 8px 0 rgba(0,0,0,.1) inset,
                    0 1px 4px 0 rgba(0,0,0,.1);

            border: 0px solid #ef4300;
        }

        .animenu__toggle {
            display: none;
            cursor: pointer;
            background-color: #111;
            border: 0;
            padding: 10px;
            height: 40px;
            width: 40px;
        }
        .animenu__toggle:hover {
            background-color: #0186ba;
        }

        .animenu__toggle__bar {
            display: block;
            width: 20px;
            height: 2px;
            background-color: #fff;
            -webkit-transition:  0.15s cubic-bezier(0.75, -0.55, 0.25, 1.55);
            -o-transition:  0.15s cubic-bezier(0.75, -0.55, 0.25, 1.55);
            transition:  0.15s cubic-bezier(0.75, -0.55, 0.25, 1.55);
        }
        .animenu__toggle__bar + .animenu__toggle__bar {
            margin-top: 4px;
        }

        .animenu__toggle--active .animenu__toggle__bar {
            margin: 0;
            position: absolute;
        }
        .animenu__toggle--active .animenu__toggle__bar:nth-child(1) {
            -webkit-transform: rotate(45deg);
            -ms-transform: rotate(45deg);
            -o-transform: rotate(45deg);
            transform: rotate(45deg);
        }
        .animenu__toggle--active .animenu__toggle__bar:nth-child(2) {
            opacity: 0;
        }
        .animenu__toggle--active .animenu__toggle__bar:nth-child(3) {
            -webkit-transform: rotate(-45deg);
            -ms-transform: rotate(-45deg);
            -o-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }

        .animenu {
            display: block;
        }

        .animenu ul {
            padding: 0;
            list-style: none;
        }
        .animenu li, .animenu a {
            display: inline-block;
            font-size: 15px;
        }
        .animenu a {
            color: #FFFFFF;
            text-decoration: none;
        }

        .animenu__nav {
            background-color: #444444;
            margin-bottom: 0;
            height: 50px;
        }

        .animenu__nav > li {
            position: relative;
        }
        .animenu__nav > li > a {
            padding: 10px 30px;
            height: 50px;
            line-height: 30px;
        }
        .animenu__nav > li > button {

        }
        .animenu__nav > li > img {
            padding: 10px 30px;
            height: 50px;
            line-height: 30px;
        }

        .animenu__nav > li > a:first-child:nth-last-child(2):before {
            opacity: 0.2;
            content: "";
            position: absolute;
            border: 4px solid transparent;
            border-bottom: 0;
            border-top-color: currentColor;
            top: 50%;
            margin-top: -2px;
            right: 10px;
        }
        .animenu__nav > li:hover > ul {
            opacity: 1;
            visibility: visible;
            margin: 0;
        }
        .animenu__nav > li:hover > a {
            background-color: #0186ba;
            border-color: #0186ba;
            color: #fff;
            height: 50px;
        }

        .animenu__nav__child {
            min-width: 100%;
            position: absolute;
            top: 100%;
            left: 0;
            z-index: 1;
            opacity: 0;
            visibility: hidden;
            margin: 20px 0 0 0;
            background-color: #373737;
            transition: margin .15s, opacity .15s;
        }
        .animenu__nav__child > li {
            width: 100%;
            border-bottom: 1px solid #515151;
        }
        .animenu__nav__child > li:first-child > a:after {
            content: '';
            position: absolute;
            height: 0;
            width: 0;
            left: 1em;
            top: 0;
            border: 6px solid transparent;
            border-top: 0;
            border-bottom-color: inherit;
        }
        .animenu__nav__child > li:last-child {
            border: 0;
        }
        .animenu__nav__child a {
            padding: 10px;
            width: 100%;
            border-color: #373737;
        }
        .animenu__nav__child a:hover {
            background-color: #0186ba;
            border-color: #0186ba;
            color: #fff;
        }

        @media screen and (max-width: 767px) {
            .animenu__toggle {
                display: inline-block;
            }

            .animenu__nav,
            .animenu__nav__child {
                display: none;
            }

            .animenu__nav {
                margin: 10px 0;
            }
            .animenu__nav > li {
                width: 100%;
                border-right: 0;
                border-bottom: 1px solid #515151;
            }
            .animenu__nav > li:last-child {
                border: 0;
            }
            .animenu__nav > li:first-child > a:after {
                content: '';
                position: absolute;
                height: 0;
                width: 0;
                left: 1em;
                top: -6px;
                border: 6px solid transparent;
                border-top: 0;
                border-bottom-color: inherit;
            }
            .animenu__nav > li > a {
                width: 100%;
                padding: 10px;
                border-color: #111;
                position: relative;
            }
            .animenu__nav a:hover {
                background-color: #0186ba;
                border-color: #0186ba;
                color: #fff;
            }

            .animenu__nav__child {
                position: static;
                background-color: #373737;
                margin: 0;
                transition: none;
                visibility: visible;
                opacity: 1;
            }
            .animenu__nav__child > li:first-child > a:after {
                content: none;
            }
            .animenu__nav__child a {
                padding-left: 20px;
                width: 100%;
            }
        }
        .animenu__nav--open {
            display: block !important;
        }
        .animenu__nav--open .animenu__nav__child {
            display: block;
        }
    </style>

    <script type="text/javascript" src="js/main.js"></script>
    <!-- //menu -->
    <script>
        $(document).ready(function() {
            $("#owl-demo").owlCarousel({

                autoPlay: 3000, //Set AutoPlay to 3 seconds
                autoPlay:true,
                items : 3,
                itemsDesktop : [640,5],
                itemsDesktopSmall : [414,4]

            });

        });
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
                <ul class="animenu__nav__child" style="text-align: center">
                    <li><a href="../action/caiyun-index.jsp">彩云之南</a></li>
                    <li><a href="../action/chunhui-index.jsp">春晖之声</a></li>
                    <li><a href="../action/cat-index.jsp">宠物之家</a></li>
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
<!-- banner -->
<div class="banner" id="home">

    <div class="container">

        <div class="w3l-banner-grids">
            <div class="col-md-8 w3ls-banner-right">
                <div class="banner-right-img">
                    <img src="images/1.jpg" alt="" />
                </div>
                <div class="banner-right-info">
                    <h2>简介</h2>
                    <p>Donec dolor felis, consectetur eget massa non, mattis euismod est. Nam augue neque, hendrerit nec scelerisque non, ultrices at ligula. Praesent posuere, turpis eget lobortis elementum, ex ante ultricies ligula, sit amet varius lacus dui in magna. Aliquam erat volutpat. Nulla condimentum, enim vitae congue ultrices, nibh erat efficitur sem, vel iaculis lectus eros in turpis. Aliquam venenatis cursus suscipit.</p>
                </div>
                <div class="clearfix"> </div>

            </div>
            <div class="col-md-4 w3ls-banner-left">
                <div class="w3ls-banner-left-info">
                    <h4>姓名</h4>
                    <p>驼鹿夫斯基的喜爱</p>
                </div>
                <div class="w3ls-banner-left-info">
                    <h4>性别</h4>
                    <p>男</p>
                </div>
                <div class="w3ls-banner-left-info">
                    <h4>地址</h4>
                    <p>大法师打发而付出vz</p>
                </div>
                <div class="w3ls-banner-left-info">
                    <h4>联系方式</h4>
                    <p>Eiusmod Tempor inclore Place,Kingsport 56777.</p>
                </div>
                <div class="w3ls-banner-left-info">
                    <h4>邮箱</h4>
                    <p><a href="mailto:example@email.com">mail@example.com</a></p>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //banner -->
<!-- about -->
<div class="about" id="about">
    <div class="container">
        <div class="wthree-about-grids">
            <div class="col-md-6 wthree-about-left">
                <h3>个人介绍</h3>
                <h4>Mauris molestie ultrices molestie. Sed rhoncus interdum ipsum, id fermentum sem pellentesque ut.</h4>
                <p>Praesent egestas egestas felis, sit amet posuere massa malesuada eget. Phasellus sem urna, euismod sit amet orci laoreet, laoreet molestie purus. Nulla leo purus, blandit nec efficitur tempor, interdum vel enim. <span>Proin mauris mi, lobortis quis quam at, tristique dictum arcu. In lobortis, massa in porta posuere, orci orci tincidunt risus, vitae ultrices enim eros vel lacus.</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tincidunt tellus at est fermentum ultricies. Cras cursus semper libero. Vivamus non elit a diam elementum vulputate ac quis nisi. Suspendisse tellus massa, tempus in tristique a, eleifend non est. Duis consequat facilisis laoreet. </p>
            </div >
            <div class="col-md-6 wthree-about-right">
                <h3>贡献</h3>
                <div class="skills-bar">
                    <section class='bar'>
                        <section class='wrap'>
                            <div class='wrap_right'>
                                <div class='bar_group'>
                                    <div class='bar_group__bar thin' label='参与活动数' show_values='true' tooltip='true' value='343'></div>
                                    <div class='bar_group__bar thin' label='发表文章数' show_values='true' tooltip='true' value='235'></div>
                                    <div class='bar_group__bar thin' label='捐款金额' show_values='true' tooltip='true' value='675'></div>
                                    <div class='bar_group__bar thin' label='评论数' show_values='true' tooltip='true' value='456'></div>
                                    <div class='bar_group__bar thin' label='HTML' show_values='true' tooltip='true' value='245'></div>
                                </div>
                            </div>
                            <div class='clear'></div>
                        </section>
                    </section>
                </div>
            </div >
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //about -->
<!-- statistics -->
<div class="jarallax statistics" id="statistics">
    <div class="container">
        <div class="w3-agileits-statistics-heading">
            <h3>My Statistics</h3>
        </div>
        <div class="agile-statistics-grids">
            <div class="col-sm-4 agile-statistics-grid">
                <h4>1024</h4>
                <i class="fa fa-desktop" aria-hidden="true"></i>
                <p>Projects Complete</p>
            </div>
            <div class="col-sm-4 agile-statistics-grid statistics-grid2">
                <h4>2746</h4>
                <i class="fa fa-user" aria-hidden="true"></i>
                <p>Clients</p>
            </div>
            <div class="col-sm-4 agile-statistics-grid">
                <h4>575</h4>
                <i class="fa fa-trophy" aria-hidden="true"></i>
                <p>Awards</p>
            </div>
            <div class="clearfix"> </div>
        </div>
        <script src="js/jarallax.js"></script>
        <script src="js/SmoothScroll.min.js"></script>
        <script type="text/javascript">
            /* init Jarallax */
            $('.jarallax').jarallax({
                speed: 0.5,
                imgWidth: 1366,
                imgHeight: 768
            })
        </script>
    </div>
</div>
<!-- //statistics -->
<!-- experience -->
<div class="experience" id="experience">
    <div class="container">
        <div class="w3-agileits-statistics-heading experience-heading">
            <h3>Work Experience</h3>
        </div>
        <div class="w3-agile-experience-grids">
            <div class="experience-top-grids">
                <div class="col-md-6 experience-grid">
                    <div class="experience-grid-icon icon-left hvr-radial-out">
                        <i class="fa fa-folder-open" aria-hidden="true"></i>
                    </div>
                    <div class="experience-grid-info">
                        <h5>Ut dapibus nisi turpis</h5>
                        <p>Curabitur augue urna, venenatis vel enim at, sodales tempus diam. Aliquam ornare, magna a cursus tempus, arcu massa accumsan justo, non facilisis risus ante vel ex.</p>
                    </div>
                </div>
                <div class="col-md-6 experience-grid experience-grid1">
                    <div class="experience-grid-icon icon-left hvr-radial-out">
                        <i class="fa fa-bell" aria-hidden="true"></i>
                    </div>
                    <div class="experience-grid-info">
                        <h5>Ut dapibus nisi turpis</h5>
                        <p>Curabitur augue urna, venenatis vel enim at, sodales tempus diam. Aliquam ornare, magna a cursus tempus, arcu massa accumsan justo, non facilisis risus ante vel ex.</p>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="experience-top-grids">
                <div class="col-md-6 experience-grid experience-grid2">
                    <div class="experience-grid-icon icon-left hvr-radial-out">
                        <i class="fa fa-comments" aria-hidden="true"></i>
                    </div>
                    <div class="experience-grid-info">
                        <h5>Ut dapibus nisi turpis</h5>
                        <p>Curabitur augue urna, venenatis vel enim at, sodales tempus diam. Aliquam ornare, magna a cursus tempus, arcu massa accumsan justo, non facilisis risus ante vel ex.</p>
                    </div>
                </div>
                <div class="col-md-6 experience-grid experience-grid3">
                    <div class="experience-grid-icon icon-left hvr-radial-out">
                        <i class="fa fa-asterisk" aria-hidden="true"></i>
                    </div>
                    <div class="experience-grid-info">
                        <h5>Ut dapibus nisi turpis</h5>
                        <p>Curabitur augue urna, venenatis vel enim at, sodales tempus diam. Aliquam ornare, magna a cursus tempus, arcu massa accumsan justo, non facilisis risus ante vel ex.</p>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
</div>
<!-- //experience -->
<!-- feedback -->
<div class="jarallax feedback">
    <div class="container">
        <div class="w3-agileits-statistics-heading">
            <h3>Clients Feedback</h3>
        </div>
        <div class="agileits-feedback-grids">
            <div id="owl-demo" class="owl-carousel owl-theme">
                <div class="item">
                    <div class="feedback-info">
                        <div class="feedback-top">
                            <p> Sed semper leo metus, a lacinia eros semper at. Etiam sodales orci sit amet vehicula pellentesque. </p>
                        </div>
                        <div class="feedback-grids">
                            <div class="feedback-img">
                                <img src="images/f1.jpg" alt="" />
                            </div>
                            <div class="feedback-img-info">
                                <h5>Peter Parker</h5>
                                <p>Vestibulum</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="feedback-info">
                        <div class="feedback-top">
                            <p> Sed semper leo metus, a lacinia eros semper at. Etiam sodales orci sit amet vehicula pellentesque. </p>
                        </div>
                        <div class="feedback-grids">
                            <div class="feedback-img">
                                <img src="images/f2.jpg" alt="" />
                            </div>
                            <div class="feedback-img-info">
                                <h5>Mary Jane</h5>
                                <p>Vestibulum</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="feedback-info">
                        <div class="feedback-top">
                            <p> Sed semper leo metus, a lacinia eros semper at. Etiam sodales orci sit amet vehicula pellentesque. </p>
                        </div>
                        <div class="feedback-grids">
                            <div class="feedback-img">
                                <img src="images/f3.jpg" alt="" />
                            </div>
                            <div class="feedback-img-info">
                                <h5>Steven Wilson</h5>
                                <p>Vestibulum</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="feedback-info">
                        <div class="feedback-top">
                            <p> Sed semper leo metus, a lacinia eros semper at. Etiam sodales orci sit amet vehicula pellentesque. </p>
                        </div>
                        <div class="feedback-grids">
                            <div class="feedback-img">
                                <img src="images/f4.jpg" alt="" />
                            </div>
                            <div class="feedback-img-info">
                                <h5>Peter Parker</h5>
                                <p>Vestibulum</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            /* init Jarallax */
            $('.jarallax').jarallax({
                speed: 0.5,
                imgWidth: 1366,
                imgHeight: 768
            })
        </script>

    </div>
</div>
<!-- //feedback -->
<!-- projects -->
<div class="projects" id="projects">
    <div class="container">
        <div class="w3-agileits-statistics-heading experience-heading">
            <h3>My Projects</h3>
        </div>
    </div>
    <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
        <ul id="myTab" class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home-main" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">All</a></li>
            <li role="presentation"><a href="#learning" role="tab" id="learning-tab" data-toggle="tab" aria-controls="learning">Apps</a></li>
            <li role="presentation"><a href="#playing" role="tab" id="playing-tab" data-toggle="tab" aria-controls="playing">Widgets</a></li>
            <li role="presentation"><a href="#painting" role="tab" id="painting-tab" data-toggle="tab" aria-controls="painting">Templates</a></li>
            <li role="presentation"><a href="#school" role="tab" id="school-tab" data-toggle="tab" aria-controls="school">Other</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home-main" aria-labelledby="home-tab">
                <div class="w3_tab_img">
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p1.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p1.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p2.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p2.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p3.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p3.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p4.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p4.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p5.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p5.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p6.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p6.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p7.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p7.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p8.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p8.jpg" alt=" " class="img-responsive" />
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="learning" aria-labelledby="learning-tab">
                <div class="w3_tab_img">
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p6.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p6.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p9.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p9.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="playing" aria-labelledby="playing-tab">
                <div class="w3_tab_img">
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p1.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p1.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p5.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p5.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p7.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p7.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p3.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p3.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="painting" aria-labelledby="painting-tab">
                <div class="w3_tab_img">
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p2.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p2.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p4.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p4.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p10.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p10.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="school" aria-labelledby="school-tab">
                <div class="w3_tab_img">
                    <div class="col-md-3 w3_tab_img_left">
                        <div class="demo">
                            <a class="cm-overlay" href="images/p8.jpg">
                                <figure class="imghvr-shutter-in-out-diag-2"><img src="images/p8.jpg" alt=" " class="img-responsive">
                                </figure>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.tools.min.js"></script>
    <script src="js/jquery.mobile.custom.min.js"></script>
    <script src="js/jquery.cm-overlay.js"></script>
    <script>
        $(document).ready(function(){
            $('.cm-overlay').cmOverlay();
        });
    </script>

</div>
<!-- //projects -->
<script src="js/bars.js"></script>
<script src="js/owl.carousel.js"></script>
</body>

</html>
