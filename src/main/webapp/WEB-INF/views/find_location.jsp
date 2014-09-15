<%@ page pageEncoding="UTF-8"%>
<div id="find-location-modal" class="modal" tabindex="-1" role="dialog"
	aria-labelledby="" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="">장소검색</h4>
			</div>
			<div class="modal-body">
				<div class="input-group">
					<input type="text" class="form-control"> <span
						class="input-group-btn">
						<button id="find-location-btn" class="btn btn-warning" type="button">검색</button>
					</span>
				</div>
				<div id="location-suggestions"">
					<div class="panel-body">
						<table></table>
					</div>
				</div>
				<div id="location-map">
					<div id="map-canvas"></div>
				</div>
			</div>
		</div>
	</div>
</div>