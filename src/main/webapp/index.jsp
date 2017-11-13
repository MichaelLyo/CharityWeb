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

    <title>һ��ƭ��Ǯ�Ĺ�����ҳ</title>

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
                            <li><img src="assets/img/logo.jpg"></li>
                            <li>
                                <a href="#home">��ҳ</a>
                            </li>
                            <li>
                                <a href="#features">�ȵ�</a>
                            </li>
                            <li>
                                <a href="#updates">���ж�</a>
                                <ul class="animenu__nav__child">
                                    <li><a href="action/caiyun-index.jsp">����֮��</a></li>
                                    <li><a href="action/chunhui-index.jsp">����֮��</a></li>
                                    <li><a href="action/cat-index.jsp">����֮��</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#installation">�ڲ���</a>
                            </li>

                            <button onclick="window.location='Login/regist.jsp'" class="button button-normal button-plain button-border button-square" style="float: right;margin: 5px 10px 10px;">ע��</button>
                            <button onclick="window.location='login.jsp'" class="button button-normal button-plain button-border button-square" style="float: right;margin: 5px 5px 10px;">��¼</button>
                        </ul>
                    </nav>
    <!-- End Navbar -->
</div> <!-- END NAVBAR -->

            <div class="slider-area">
                    <div id="slide-list" class="carousel-fade slide" data-ride="carousel">
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
                                                            <h2>�����������һ��Լ�� </h2>
                                                            <p>2015������죬����˿˿���������������飬ͬ�ô�ѧ����֧��Э��������ӵ����ǣ�����ǰ��������ʡ������������ݺ����ػ�ƺ�������С������ͬ���ǣ������������Լ����</p>
                                                            <a href="action/activity.jsp" class="readmore">�˽����</a>
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
                                                            <h2>ͬ�ô�ѧè��ͬ��</h2>
                                                            <p>��һ��������Ҫ����~��è��ͬ�˺�@����è��è��վ-�Ϻ� ���������������������׼�������У���ʱ��ӭǰ������С������~~</p>
                                                            <a href="action/activity.jsp" class="readmore">�˽����</a>
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
                                                            <h2>�ļ����͡�����ǭ��</h2>
                                                            <p>ͬ��־Ը���Ǵ���˸��е�СС־Ը�����������������ݿ�չ�������ʮ�ֿ��ʣ��ڽ����˴������ָ��������ҲϤ�ĵؽ����������С�ĺ�������ֽ���������ǿ�ҵ����������޼�ؽ�������ͨ��</p>
                                                            <a href="action/activity.jsp" class="readmore">�˽����</a>
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
                    <img src="assets/img/font-hotnew.png">
                    <div class="news-article">
                        <div class="col-md-6 article-post">
                            <a href="action/activity.jsp" ><img src="assets/img/cat-top.jpg" alt="img07"/></a>
                            <div class="col-md-3 post-meta">
                                <div class="meta-icon">
                                    <div class="pic">
                                        <a href="action/activity.jsp" > <i class="glyphicon glyphicon-picture"></i></a>
                                    </div>
                                </div>
                                <ul class="ad-info">
                                    <li>2017  10.20</li>
                                    <li> <a href="Login/userInfo.jsp">ţ����</a></li>
                                    <li> <a href="#">24 ����</a></li>
                                </ul>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="col-md-9 post-details">
                                <a href="action/activity.jsp"><h3>ѡ��������ѡ���򲻵��İ�</h3></a>
                                <p>��������12.6������è��ͬ��è��ͬ�˽���ͬ�ٵİ���������������Լ���У��ڻ�ֳ�����ֻè��ɹ��������ҵ������������Լ��������ޣ�����è�������ע���ǽ����ͥ��������������������������Щ�����������µ������أ�</p>
                                <div>
                                    <a class="blog hvr-shutter-out-horizontal" href="action/activity.jsp" role="button">�鿴����</a>
                                </div>
                            </div>
                            <!--post-details-->
                            <div class="clearfix"> </div>
                        </div>
                        <div class="col-md-6 article-post">
                            <a href="action/activity.jsp" ><img src="assets/img/caiyun-top.jpg" alt="img07"/></a>
                            <div class="col-md-3 post-meta">
                                <div class="meta-icon">
                                    <div class="pic">
                                        <a href="action/activity.jsp" > <i class="glyphicon glyphicon-picture"></i></a>
                                    </div>
                                </div>
                                <ul class="ad-info">
                                    <li>2017  9.23</li>
                                    <li> <a href="#">����ţ��</a></li>
                                    <li> <a href="#">23 ����</a></li>
                                </ul>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="col-md-9 post-details">
                                <a href="action/activity.jsp"><h3>־Ը�����������</h3></a>
                                <p>д����Щ����������Ӫ����֮ʱ�������ȥ��ʮ�죬�·���Щ��㱡���һ����Ϊ��Ӵ���ʮ��С���һ��ǰ����أ��о������ˡ�������������Ȥ��Ŭ����С��飻���������˿ɰ��ָ��ڳ��Եĺ����ǡ���</p>
                                <div>
                                    <a class="blog hvr-shutter-out-horizontal" href="action/activity.jsp" role="button">�鿴����</a>
                                </div>
                            </div>
                            <!--post-details-->
                            <div class="clearfix"> </div>
                        </div>
                        <div class="see-button">
                            <a class="btn btn-primary btn-lg see-button hvr-shutter-out-horizontal serve-button" href="hotspot/hotspot-index.jsp" role="button">�鿴�����ȵ�</a>
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
                    <img src="assets/img/font-action.png">
                    <div class="service-grid">
                        <div class="col-md-4 ser-in post-details">
                            <a href="action/caiyun-index.jsp" class="b-link-stripe b-animate-go  thickbox"><div class="b-line b-line1"></div><div class="b-line b-line2"></div><div class="b-line b-line3"></div><div class="b-line b-line4"></div><div class="b-line b-line5"></div>
                                <img class="img-responsive" src="assets/img/caiyun-participate.jpg" style="top: 0px;" alt=" " /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="assets/img/plus.png" alt="" style="top: 0px;"></h2>
                                </div></a>
                            <h3>�� �� ֧ ��</h3>
                            <span>ͬ�ô�ѧ����֧��Э��</span>
                            <p>�˽⹫�������������˼�롣ͬ����ͬ�У�����֧�ϣ�Բ��һ�������Σ������ڴͬ�ô�ѧ�����ϵ�����ͨ�����Ĺ���ƽ̨��ͨ���ḻ�Ļ����ͬ��ѧ��Ӧ���Լ���רҵ֪ʶ���س����������������������Ұ���õ������ע��</p>
                            <a href="action/caiyun-index.jsp" class="btn  btn-1c btn1 btn-1d">�������</a>
                        </div>
                        <div class="col-md-4 ser-in post-details">
                            <a href="action/chunhui-index.jsp" class="b-link-stripe b-animate-go  thickbox"><div class="b-line b-line1"></div><div class="b-line b-line2"></div><div class="b-line b-line3"></div><div class="b-line b-line4"></div><div class="b-line b-line5"></div>
                                <img class="img-responsive" src="assets/img/chunhui-participate.jpg" style="top: 0px;" alt=" " /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="assets/img/plus.png" alt="" style="top: 0px;"></h2>
                                </div></a>
                            <h3><b>�� �� ֮ ��</b></h3>
                            <span>ͬ�ô�ѧ��������</span>
                            <p>�������;��񣬼��д������ͬ�ô�ѧ���������ڹ���ʡ��ί����Ĵ�����ṫ�������������ж�����Ӱ���£���ͬ�ô�ѧУ��ί��׼������ѧ���������š����������ڴ������;��񣬼��д������Ϊ��ѧ�����빫�桢������ᴴ�������ƽ̨��</p>
                            <a href="action/chunhui-index.jsp" class="btn  btn-1c btn1 btn-1d">�������</a>
                        </div>
                        <div class="col-md-4 ser-in post-details">
                            <a href="action/cat-index.jsp" class="b-link-stripe b-animate-go  thickbox"><div class="b-line b-line1"></div><div class="b-line b-line2"></div><div class="b-line b-line3"></div><div class="b-line b-line4"></div><div class="b-line b-line5"></div>
                                <img class="img-responsive" src="assets/img/cat-participate.jpg" style="top: 0px;" alt=" " /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="assets/img/plus.png" alt="" style="top: 0px;"></h2>
                                </div></a>
                            <h3><b>�� �� ֮ ��</b></h3>
                            <span>ͬ��è��</span>
                            <p>ͬ��è�ˣ�һ��������è�䱣���Ĺ�����ѧ�����ţ�è����һ��������ʵ���ࡿ���ţ������ڸ���ͬ��è������滷�������ǵ���ּ�ǣ���ͬ�õ�è������ø��ã���ͬ�õ�У԰�����а�������è�˳�Ա���������ȡè��������ָ��è�����Żݡ�
                            </p>
                            <a href="action/cat-index.jsp" class="btn  btn-1c btn1 btn-1d">�������</a>
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
                <img src="assets/img/font-participate.png">
                <div class="container">

                    <div class="col-md-5 serve-info">
                        <h5>���ǻ᲻�ϸ��¸��๫�����ڴ������ѡ�����κη�ʽ���뵽����֮�С�����԰����׶����м��ˣ�Ҳ���Ա���������������Ȼ��</h5>
                        <h3 style = "color: #2BCFC2;font-size: 40px;">�������Ȼ</h3>
                        <a href="action/activity.jsp"><img src="assets/img/action.jpg"></a>
                        <div class="see-button">
                            <a class="btn btn-primary btn-lg see-button hvr-shutter-out-horizontal serve-button" href="participate/participate-index.jsp" role="button">�鿴����</a>
                        </div>
                    </div>
                    <div class="col-md-7 serve-grids">
                        <div class="serve-grids-top">
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s1.png" alt="" />
                                </figure>
                                <h5>��ͯ����</h5>
                                <p>�������������������������ĵĶ�ͯ�����������¶����չ˲м���ͯ��ȥƶ��ɽ��֧�̵Ȼ��</p>
                            </div>
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s2.png" alt="" />
                                </figure>
                                <h5>�м��˷���</h5>
                                <p>����ͬʱΪ�м����ṩ�����Լ���������߲м��˵�����Ʒ�ʣ������м��˽�����ѡ�</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="serve-grids-top">
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s4.png" alt="" />
                                </figure>
                                <h5>��������</h5>
                                <p>���ڶ๫���������Ϊ������������һ�������������������ֵ�����Ϊ���ǵ���������һ�������Ļ���</p>
                            </div>
                            <div class="col-md-6 service-box">
                                <figure class="icon">
                                    <img src="assets/img/s3.png" alt="" />
                                </figure>
                                <h5>���</h5>
                                <p>����ͬʱ�ṩ��ֱ�ӵĹ�����뷽ʽ��Ϊƶ�����������Լ���һ���ʽ�</p>
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

            <div id="primary" class="content-area col-md-9 classic">
                <main id="main" class="post-wrap" role="main">


                    <div class="posts-layout">


                        <article id="post-675" class="post-675 post type-post status-publish format-standard hentry category-uncategorized">


                            <header class="entry-header">
                                <h2 class="title-post entry-title"><a href="http://litta.co/fly-tipper-cctv-enfield/" rel="bookmark">Prolific fly-tipper caught on CCTV Enfield</a></h2>
                                <div class="meta-post">
                                    <span class="posted-on">Posted on <a href="http://litta.co/fly-tipper-cctv-enfield/" rel="bookmark"><time class="entry-date published updated" datetime="2017-07-10T08:46:44+00:00">July 10, 2017</time></a></span><span class="byline"> <span class="author vcard"><a class="url fn n" href="http://litta.co/author/littaappdev/">littaappdev</a></span></span><span class="comments-link"><a href="http://litta.co/fly-tipper-cctv-enfield/#respond">Leave a comment</a></span><span class="cat-links">Posted in <a href="http://litta.co/category/uncategorized/" rel="category tag">Uncategorized</a></span>		</div><!-- .entry-meta -->
                            </header><!-- .entry-header -->

                            <div class="entry-post">
                                <p>Police hunting the criminal said: &#8220;Individuals have been approached by ��Jason�� to have their waste taken away. The same waste has then been fly-tipped instead of being disposed of legally, often using a four-door tipper truck with the registration plate NG54 0BA, which has been caught on CCTV. &#8220;However, the DVLA has no details of [&hellip;]</p>

                            </div><!-- .entry-post -->

                            <footer class="entry-footer">
                            </footer><!-- .entry-footer -->
                        </article><!-- #post-## -->


                        <article id="post-1" class="post-1 post type-post status-publish format-standard hentry category-uncategorized tag-flytipping tag-illegal-dumping tag-rubbish tag-waste">


                            <header class="entry-header">
                                <h2 class="title-post entry-title"><a href="http://litta.co/council-warning-flytipping-guidance/" rel="bookmark">Guidance given to chose wisely who disposes of your waste</a></h2>
                                <div class="meta-post">
                                    <span class="posted-on">Posted on <a href="http://litta.co/council-warning-flytipping-guidance/" rel="bookmark"><time class="entry-date published" datetime="2017-06-02T11:01:04+00:00">June 2, 2017</time><time class="updated" datetime="2017-06-14T13:35:37+00:00">June 14, 2017</time></a></span><span class="byline"> <span class="author vcard"><a class="url fn n" href="http://litta.co/author/littaappdev/">littaappdev</a></span></span><span class="comments-link"><a href="http://litta.co/council-warning-flytipping-guidance/#comments">1 Comment</a></span><span class="cat-links">Posted in <a href="http://litta.co/category/uncategorized/" rel="category tag">Uncategorized</a></span>		</div><!-- .entry-meta -->
                            </header><!-- .entry-header -->

                            <div class="entry-post">
                                <p>Who have you used in the past to dispose of your waste? Guidance in Sheffield is now being given by the police and council for individuals to be extra careful when choosing who they use for this service. Read the full article here http://www.thestar.co.uk/news/police-and-council-issue-plea-over-fly-tipping-in-sheffield-1-8592134 &nbsp; &nbsp; &nbsp;</p>

                            </div><!-- .entry-post -->

                            <footer class="entry-footer">
                            </footer><!-- .entry-footer -->
                        </article><!-- #post-## -->
                    </div>



                </main><!-- #main -->
            </div><!-- #primary -->
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
                        3: 'installation',
                        4: 'one-pager'
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
