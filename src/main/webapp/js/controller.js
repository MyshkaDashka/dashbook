app.controller("Controller", function ($scope, FileUploader) {
    var uploader = $scope.uploader = new FileUploader({
        url: '/upload'
    });
});