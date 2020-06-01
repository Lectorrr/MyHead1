window._originalAlert = window.alert;
window.alert = function(text) {
	var bootStrapAlert = function() {
		if (!$.fn.modal.Constructor)
			return false;
		if ($('#windowAlertModal').length == 1)
			return true;
		$('body')
				.append(
						'<div id="windowAlertModal" class="modal fade" tabindex="-1" data-backdrop="static">\
						<div class="modal-dialog">\
						<div class="modal-content">\
							<div class="modal-body">\
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> \
								<p> alert text </p> \
							</div>\
							<div class="modal-footer no-margin-top">\
								<div class="text-right">\
									<button class="btn btn-danger" data-dismiss="modal">\
										确定\
									</button>\
								</div>\
							</div>\
						</div>\
					</div>\
				</div>');

		return true;
	}
	if (bootStrapAlert()) {
		$('#windowAlertModal .modal-body p').text(text);
		$('#windowAlertModal').modal("toggle");
	} else {
		console.log('bootstrap was not found');
		window._originalAlert(text);
	}
}
window._originalConfirm = window.confirm;
window.confirm = function(text, cb) {
	var initTemplate = function() {
		if ($('#windowConfirmModal').length == 1)
			return true;
		$('body')
				.append(
						' \
        <div id="windowConfirmModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true"> \
						<div class="modal-dialog">\
						<div class="modal-content">\
          <div class="modal-body"> \
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> \
            <p> alert text </p> \
          </div> \
          <div class="modal-footer"> \
            <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">关闭</button> \
            <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button> \
          </div> \
        </div> \
						</div>\
						</div>\
      ');
	}

	var bootStrapConfirm = function() {
		if (!$.fn.modal.Constructor)
			return false;

		$('body').off('click', '#windowConfirmModal .btn-primary');
		$('body').off('click', '#windowConfirmModal .btn-danger');

		function confirm() {
			cb(true);
		}
		function deny() {
			cb(false);
		}

		$('body').on('click', '#windowConfirmModal .btn-primary', confirm);
		$('body').on('click', '#windowConfirmModal .btn-danger', deny);

		return true;

	}

	initTemplate()

	if (bootStrapConfirm()) {
		$('#windowConfirmModal .modal-body p').text(text);
		$('#windowConfirmModal').modal();
	} else {
		console.log('bootstrap was not found');
		cb(window._originalConfirm(text));
	}
	//阻止body根据弹框而移动
	$('body').removeAttr("style");
}