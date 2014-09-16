<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet"  type="text/css" />
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/css/register_guest.css" />" rel="stylesheet"  type="text/css" />
<link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet"  type="text/css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.string/2.3.3/underscore.string.min.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCd8g41gqlpEGM2lchBKI_1mcH2MYqcXPY&sensor=false&v=3.exp"></script>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<title>바스켓볼 게스트</title>
</head>
<body>
<div id="wrap">
	<div id="container">
		<%@ include file="find_location.jsp" %>
		<div id="register-guest-form">
			<fieldset>
				<!-- Form Name -->
				<h3>구인등록</h3>
				<hr/>
				<form:form name="registerGuestForm" id="form" method="post" modelAttribute="guest">
				    <div class="form-group">
				      <section>
					      <form:input path="" type="text" class="form-control" placeholder="장소" data-toggle="modal" data-target="#find-location-modal" style="width:inherit;"/>
				      </section>
				      <section id="">
				      	  <!--
					      <button class="btn btn-warning btn-large"  id="" onclick="">
					       	등록
					      </button>
					      -->
				      </section>
				    </div>
				 </form:form>
			 </fieldset>
		 </div>
	</div>
</div>
<!--datepicker
<input type="text" class="span2" value="" id="dpd1" >
$('#dpd1').datepicker(); -->
<script type="text/javascript">
	$(document).ready(function(){
		var mapHandler = (function(){
			var map, center, latLngAry, marker,
			mapOptions = {
		      zoom: 17,
		      draggable: true,
		      scrollwheel: true,
		    }, test = 1;
			return{ 
				resizeMap : function(callback) {
				   if(_.isUndefined(map)) return;
				   _.delay(function(){
					   google.maps.event.trigger(map, "resize");
					   map.setCenter(center);
					   callback.call(callback);
				   },1000);
				},
				search : function(query){
					$.ajax({
					   url:"/bg-www/location/search",
					   type:"POST",
					   data:{query:query},
					   dataType: "json",
					   success: function(resp){
						   latLngAry = resp;
						   var html = "<table class=\"table\"><tbody>";
						   _.each(resp,function(object){
							  html += "<tr><td>";
							  html += object.name+"("+object.formatted_address+")";
							  html += "</td></tr>";
						   });
						   html += "</tbody></table>";
						   $("#location-suggestions .panel-body table").replaceWith(html);
					   },
					   error: function(resp){
						   alert("일시적인 장애입니다.");
					   }
				   });
				},
				getLatLngAry : function(){
					return latLngAry;
				},
				hideGoogleMapCanvas : function(){
					$("#location-map").css("display","none");
				},
				showGoogleMapCanvas : function(){
					$("#location-map").css("display","block");
				},
				showGoogleMap : function(location){
					center = new google.maps.LatLng(location.lat, location.lng);
					mapOptions.center = center;
					map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
					marker = new google.maps.Marker({
					    position:center
					});
					marker.setMap(map);
					google.maps.event.addListener(marker, 'click', function() {
					    if(confirm(location.name+"을 선택하시겠습니까?")){
					    	$("#find-location-modal").modal("hide");
					    }
					});
				}
			};
		}());
		$('#find-location-modal').on('show.bs.modal', function() {
		   //mapHandler.resizeMap(function(){
		   //});
		});
		
		$("#find-location-btn").click(function(){
			var query = $("#find-location-modal .modal-body .input-group .form-control").val();
			if(_.string.isBlank(query)){
				alert("장소를 입력해 주세요.");
			}
			mapHandler.hideGoogleMapCanvas();
			mapHandler.search(query);
		});
		
		$(document).on("click", "#location-suggestions .panel-body table tbody tr", function(){
			mapHandler.showGoogleMapCanvas();
			mapHandler.showGoogleMap(mapHandler.getLatLngAry()[$("#location-suggestions .panel-body table tbody tr").index(this)]);
			$("#location-suggestions .panel-body table").children().remove();
		});
	});
</script>
</body>
</html>