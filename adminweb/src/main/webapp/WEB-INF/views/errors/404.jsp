  <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <title>金茂会员服务（质量管理）管理系统</title>
  <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="keywords" content="">
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- Bootstrap Core CSS -->
  <link href="../static/css/bootstrap.css" rel="stylesheet" type="text/css">
  <!-- Custom CSS -->
  <link href="../static/css/style.css" rel="stylesheet" type="text/css">
  <!-- font CSS -->
  <!-- font-awesome icons -->
  <link href="../static/css/font-awesome.css" rel="stylesheet">
  <!-- //font-awesome icons -->
  <!-- js-->
  <script src="../static/js/jquery-1.11.1.min.js"></script>
  <script src="../static/js/modernizr.custom.js"></script>
  <!--animate-->
  <link href="../static/css/animate.css" rel="stylesheet" type="text/css" media="all">
  <script src="../static/js/wow.min.js"></script>
  <script>
    new WOW().init();
  </script>
  <!--//end-animate-->
  <!-- Metis Menu -->
  <script src="../static/js/metisMenu.min.js"></script>
  <script src="../static/js/custom.js"></script>
  <link href="../static/css/custom.css" rel="stylesheet">
  <!--//Metis Menu -->
</head>
<body class="cbp-spmenu-push cbp-spmenu-push-toright">
<div class="main-content">

  <div class=" sidebar" role="navigation">
    <div class="navbar-collapse"></div>
    <div class="sticky-header header-section "><div>
      <div class="header-left">
        <div class="logo"><a href="#" class="fl logo block mt20 ml50"><img src="../static/images/ui/logo.png"></a></div>
        <div class="clearfix"> </div>
      </div>
      <div class="header-right">
        <div class='profile_details'>
          <%--<span>2016-01-20</span>--%>
          <%--<span> 您好，张三</span>--%>
          <%--<span>北京人家小区</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
          <%--<a href='../user/passManage.html' ><span  class='glyphicon glyphicon-edit'></span> 密码修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
          <%--<a href='../login/logOut.html' ><span  class='glyphicon glyphicon-log-out'></span> 退出</a>--%>
        </div>
      </div>
      <div class="clearfix"> </div>
    </div>
    </div>
    <!-- main content start-->
    <div id="page-wrapper" style="min-height: 205px;">
      <div class="main-page">

        <div class="forms">

          <div class="row">
            <div class="col-md-6 validation-grids validation-grids-right">
              <div class="widget-shadow " data-example-id="basic-forms">
                <a href="../" ><span
                        class="glyphicon glyphicon-log-out"></span>网页过期，请重新登录！</a>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
  <!-- main content end-->


  <!--footer-->
  <div class="footer">
    <div class="container">
      <span class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：迈动互联(北京)信息科技有限公司<b>&nbsp;4006-612-966</b></span>
      <span class="pull-right">JINMAO Group 版权所有</span>
    </div>
  </div>
  <!--//footer-->
</div>
<!-- Classie -->
<script src="../static/js/classie.js"></script>
<script>
  var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
          showLeftPush = document.getElementById( 'showLeftPush' ),
          body = document.body;

  showLeftPush.onclick = function() {
    classie.toggle( this, 'active' );
    classie.toggle( body, 'cbp-spmenu-push-toright' );
    classie.toggle( menuLeft, 'cbp-spmenu-open' );
    disableOther( 'showLeftPush' );
  };

  function disableOther( button ) {
    if( button !== 'showLeftPush' ) {
      classie.toggle( showLeftPush, 'disabled' );
    }
  }
</script>
<!--scrolling js-->
<script src="../static/js/jquery.nicescroll.js"></script>
<script src="../static/js/scripts.js"></script><div id="ascrail2000" class="nicescroll-rails" style="width: 6px; z-index: 1000; background-color: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none; background-position: initial initial; background-repeat: initial initial;"><div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(242, 179, 63); border: 0px; background-clip: padding-box; border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-right-radius: 10px; border-bottom-left-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background-color: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; background-position: initial initial; background-repeat: initial initial;"><div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(242, 179, 63); border: 0px; background-clip: padding-box; border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-right-radius: 10px; border-bottom-left-radius: 10px;"></div></div>
<!--//scrolling js-->
<!-- Bootstrap Core JavaScript -->
<script src="../static/js/bootstrap.js"> </script>



</body>

</html>