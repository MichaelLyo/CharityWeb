<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="stickUp ��һ��jQuery�����������ҳ���ϵ��κ�һ��Ԫ�ع̶��ڴ��ڻ���Ļ�Ķ�����һ�����ڽ��˵��򵼺����̶���ҳ�涥����">
    <meta name="author" content="Liran Cohen">
    <meta name="translation" content="Bootstrap������">

    <title>stickUp - һ�� jQuery ���</title>

    <!-- Bootstrap & Snippet plugin core CSS -->
    <link href="http://cdn.bootcss.com/twitter-bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/stickup.css" rel="stylesheet">
    <link href="assets/css/button.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/layout.css" rel="stylesheet">
    <link href="assets/css/anticipate.css" rel="stylesheet">
</head>
<body>
<div id="home" class="carousel">
        <div class="item active">

<!-- START THE NAVBAR -->
<div class="navbar-wrapper">

                    <nav class="animenu">
                        <button class="animenu__toggle">
                            <span class="animenu__toggle__bar"></span>
                            <span class="animenu__toggle__bar"></span>
                            <span class="animenu__toggle__bar"></span>
                        </button>
                        <ul class="animenu__nav">
                            <li>
                                <a href="#home">��ҳ</a>
                            </li>
                            <li>
                                <a href="#features">�ȵ�</a>
                            </li>
                            <li>
                                <a href="#updates">���ж�</a>
                                <ul class="animenu__nav__child">
                                    <li><a href="">����֮��</a></li>
                                    <li><a href="">����֮��</a></li>
                                    <li><a href="">����֮��</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#installation">�ڲ���</a>
                            </li>
                            <li>
                                <a href="login.jsp">��¼</a>
                            </li>
                        </ul>
                    </nav>
    <!-- End Navbar -->
</div> <!-- END NAVBAR -->
<!-- START THE COVER -->

                <div class="slider-area">
                    <div class="zigzag-bottom"></div>
                    <div id="slide-list" class="carousel carousel-fade slide" data-ride="carousel">


                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <div class="single-slide">
                                    <div class="slide-bg slide-one"></div>
                                    <div class="slide-text-wrapper">
                                        <div class="slide-text">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 col-md-offset-6">
                                                        <div class="slide-content">
                                                            <h2>We are awesome</h2>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur, dolorem, excepturi. Dolore aliquam quibusdam ut quae iure vero exercitationem ratione!</p>
                                                            <a href="" class="readmore">Learn more</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="single-slide">
                                    <div class="slide-bg slide-two"></div>
                                    <div class="slide-text-wrapper">
                                        <div class="slide-text">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 col-md-offset-6">
                                                        <div class="slide-content">
                                                            <h2>We are great</h2>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe aspernatur, dolorum harum molestias tempora deserunt voluptas possimus quos eveniet</p>
                                                            <a href="" class="readmore">Learn more</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="single-slide">
                                    <div class="slide-bg slide-three"></div>
                                    <div class="slide-text-wrapper">
                                        <div class="slide-text">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 col-md-offset-6">
                                                        <div class="slide-content">
                                                            <h2>We are superb</h2>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores, eius?</p>
                                                            <a href="" class="readmore">Learn more</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="slide-bulletz">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ol class="carousel-indicators slide-indicators">
                                            <li data-target="#slide-list" data-slide-to="0" class="active"></li>
                                            <li data-target="#slide-list" data-slide-to="1"></li>
                                            <li data-target="#slide-list" data-slide-to="2"></li>
                                        </ol>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
              <!-- End slider area -->
            </div>
        </div><!-- END COVER -->
</div>
    <!-- START THE CONTENT -->
    <div id='contents'>

        <!-- START THE FEATURES -->
        <div id="features" class="featurette container marketing">
            <!--start-news-->
            <div class="news services-in">
                <div class="container">
                    <h3 class="tittle">Our News</h3>
                    <div class="news-article">
                        <div class="col-md-6 article-post">
                            <a href="single.html" ><img src="assets/img/n1.jpg" alt="img07"/></a>
                            <div class="col-md-3 post-meta">
                                <div class="meta-icon">
                                    <div class="pic">
                                        <a href="single.html" > <i class="glyphicon glyphicon-picture"></i></a>
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
                                <a href="single.html"><h3>To Protect Humanity</h3></a>
                                <p>Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo.</p>
                                <div>
                                    <a class="blog hvr-shutter-out-horizontal" href="single.html" role="button">Read More</a>
                                </div>
                            </div>
                            <!--post-details-->
                            <div class="clearfix"> </div>
                        </div>
                        <div class="col-md-6 article-post">
                            <a href="single.html" ><img src="assets/img/n2.jpg" alt="img07"/></a>
                            <div class="col-md-3 post-meta">
                                <div class="meta-icon">
                                    <div class="pic">
                                        <a href="single.html" > <i class="glyphicon glyphicon-picture"></i></a>
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
                                <a href="single.html"><h3>To Protect Humanity</h3></a>
                                <p>Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo.</p>
                                <div>
                                    <a class="blog hvr-shutter-out-horizontal" href="single.html" role="button">Read More</a>
                                </div>
                            </div>
                            <!--post-details-->
                            <div class="clearfix"> </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            <!--//news-->


    </div> <!-- END FEATURES -->

        <!-- START THE UPDATES -->
        <div id="updates" class="row featurette">
            <!-- �۽� ��̬�ȵĹ���Ӱ�� -->
            <div class="services-in post-details">
                <div class="container">
                    <h3 class="tittle">Our Action</h3>
                    <div class="service-grid">
                        <div class="col-md-4 ser-in post-details">
                            <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><div class="b-line b-line1"></div><div class="b-line b-line2"></div><div class="b-line b-line3"></div><div class="b-line b-line4"></div><div class="b-line b-line5"></div>
                                <img class="img-responsive" src="assets/img/pic.jpg" style="top: 0px;" alt=" " /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="assets/img/plus.png" alt="" style="top: 0px;"></h2>
                                </div></a>
                            <h3>�� �� ֮ ��</h3>
                            <span>Claritas est etiam</span>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,.</p>
                            <a href="#" class="btn  btn-1c btn1 btn-1d">MORE INFO</a>
                        </div>
                        <div class="col-md-4 ser-in post-details">
                            <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><div class="b-line b-line1"></div><div class="b-line b-line2"></div><div class="b-line b-line3"></div><div class="b-line b-line4"></div><div class="b-line b-line5"></div>
                                <img class="img-responsive" src="assets/img/pic1.jpg" style="top: 0px;" alt=" " /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="assets/img/plus.png" alt="" style="top: 0px;"></h2>
                                </div></a>
                            <h3>�� �� ֮ ��</h3>
                            <span>Claritas est etiam</span>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,.</p>
                            <a href="#" class="btn  btn-1c btn1 btn-1d">MORE INFO</a>
                        </div>
                        <div class="col-md-4 ser-in post-details">
                            <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><div class="b-line b-line1"></div><div class="b-line b-line2"></div><div class="b-line b-line3"></div><div class="b-line b-line4"></div><div class="b-line b-line5"></div>
                                <img class="img-responsive" src="assets/img/pic2.jpg" style="top: 0px;" alt=" " /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="assets/img/plus.png" alt="" style="top: 0px;"></h2>
                                </div></a>
                            <h3>�� �� ֮ ��</h3>
                            <span>Claritas est etiam</span>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,.</p>
                            <a href="#" class="btn  btn-1c btn1 btn-1d">MORE INFO</a>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>

        </div> <!-- END UPDATES -->

        <!-- START THE INSTALLATION -->
        <div id="installation" class="row featurette">
            <!--start-services-->
            <div class="services-in">
                <!-- container -->
                <div class="container">
                    <h3 class="tittle">Our Services</h3>
                    <div class="col-md-5 serve-info">
                        <h5>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Cras porttitor imperdiet volutpat nulla malesuada lectus eros ut convallis felis consectetur ut </h5>

                        <div class="see-button">
                            <a class="btn btn-primary btn-lg see-button hvr-shutter-out-horizontal serve-button" href="#" role="button">Read More</a>
                        </div>
                    </div>
                    <div class="col-md-7 serve-grids">
                        <div class="serve-grids-top">
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s1.png" alt="" />
                                </figure>
                                <h5>Kindness</h5>
                                <p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                            </div>
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s2.png" alt="" />
                                </figure>
                                <h5>Humanity</h5>
                                <p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="serve-grids-top">
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s4.png" alt="" />
                                </figure>
                                <h5>Save Food</h5>
                                <p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                            </div>
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s3.png" alt="" />
                                </figure>
                                <h5>Save Money</h5>
                                <p>Sed ut perspiciis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!-- //container -->
            </div>
            <!-- //serve -->

            <div class="col-md-5">
            </div>
        </div>  <!-- END INSTALLATION -->

        <!-- START THE ONE-PAGER -->
        <div id="one-pager" class="row featurette">
            <div class="col-md-5">
            </div>
            <div class="col-md-7">
                <h2 class="featurette-heading">����ҳ������<span class="text-muted"><br>�Լ����԰�</span></h2>
                <p class="lead">������ҳ�沼��Ϊ��ҳ�浼������ϣ��������һֱ�̶��ڶ��������û���ʱ֪���Լ�������λ�ã�ֻ�谴������Ĳ�������������ʵ�֡�</p>
                <p class="lead">
                    <b>��һ����</b> �ռ�ҳ�������н�Ҫ��Ϊê���Ԫ�ء�<br>
                </p>
                <p class="lead">
                    <small><i>�����ЩԪ�ػ�û�б����� <b>"id="</b> ���ԣ���Ϊ�����úá�</i></small>
                </p>
                <p class="lead">
                    <b>��������</b> �޸� <i>stickUp</i> ��������ô������£�
                </p>
                <xmp>
                    <script type="text/javascript">
                        //initiating jQuery
                        jQuery(function($) {
                            $(document).ready( function() {
                                //Ϊ '.navbar-wrapper' class ����stickUp���
                                $('.navbar-wrapper').stickUp({
                                    parts: {
                                        0:'home',
                                        1:'features',
                                        2: 'news',
                                        3: 'installation'
                                    },
                                    itemClass: 'menuItem',
                                    itemHover: 'active'
                                });
                            });
                        });

                    </script>
                </xmp>
                <p class="lead">
                    **��������ֱ�ע����Ԫ�س��ֵ�˳��
                    <br><br>
                    <b>itemClass:</b> ��ÿ�������˵���Ŀ����Ӧ�ĵ�class��<br>
                    <b>itemHover:</b> �ǵ��˵���Ŀ���ڼ���״̬ʱ���������class�������޸�����ۡ�
                </p>
            </div>
        </div>  <!-- END ONE-PAGER -->

    <!-- Bootstrap & Plugins core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery-2.1.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- ### IMPORTANT ### stickUp javascript file -->
    <!-- ######################################### -->
    <script src="assets/js/stickUp.min.js"></script>
    <!-- ######################################### -->

    <!-- ### IMPORTANT ### stickUp options in use -->
    <!-- ######################################## -->
    <script type="text/javascript">
        jQuery(function($) {
            $(document).ready( function() {
                $('.animenu__nav').stickUp({
                    parts: {
                        0:'home',
                        1:'features',
                        2: 'updates',
                        3: 'installation'
                    },
                    itemClass: 'menuItem',
                    itemHover: 'active',
                    topMargin: 'auto'
                });
            });
        });
    </script>
    </div>
    <!-- ######################################## -->
</body>
</html>
