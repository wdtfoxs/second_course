var roomListApp = angular.module("roomListApp", []);
roomListApp.controller("RoomListController", function ($scope) {
    var holdThing;
    var roomWidth = mainRoom.width;
    var roomHeight = mainRoom.height;

    $scope.list = model;
    $scope.addNewFurniture = function () {
        if ($scope.roomName.length > 0 && $scope.width > 0 && $scope.width < mainRoom.width
            && $scope.length > 0 && $scope.length < mainRoom.height) {
            if ($scope.color == null) $scope.color = "gray";
            model.furniture.push({
                name: $scope.roomName,
                width: $scope.width,
                length: $scope.length,
                coordX: 0,
                coordY: 0,
                color: $scope.color
            });
        }
        $scope.roomName = "";
        $scope.width = "";
        $scope.length = "";
        $scope.coordX = "";
        $scope.coordY = "";
        $scope.color = "";
    };
    $scope.delete = function (index) {
        model.furniture.splice(index, 1);
    };

    $scope.rotateFurniture = function (furniture) {
        var length = furniture.length;
        furniture.length = furniture.width;
        furniture.width = length;

    };
    $scope.thingStyle = function (thing) {
        var width, height;
        thing.width >= roomWidth ? width = roomWidth - thing.coordX : width = thing.width;
        thing.length >= roomHeight ? height = roomHeight - thing.coordY : height = thing.length;

        return "background:" + thing.color + "; width:" + width + "px; height:" +
            height + "px; top:" + thing.coordY + "px; left:" + thing.coordX + "px";
    };
    $scope.mainRoomStyle = function () {
        return "width:" + mainRoom.width + "px; height:" + mainRoom.height + "px";
    };
    $scope.holdObject = function (thing) {
        mouse.coordX = MouseCoords.getX(event);
        mouse.coordY = MouseCoords.getY(event);
        mouse.divX = mouse.coordX - thing.coordX;
        mouse.divY = mouse.coordY - thing.coordY;
        holdThing = thing;
    };

    $scope.move = function () {
        if (holdThing != null) {//движение с зажатой мышью
            var x = MouseCoords.getX(event) - mouse.divX;
            var y = MouseCoords.getY(event) - mouse.divY;
            if (x < 0) holdThing.coordX = 0;
            else if (x + Number(holdThing.width) > roomWidth) holdThing.coordX = roomWidth - Number(holdThing.width);
            else holdThing.coordX = x;
            if (y < 0) holdThing.coordY = 0;
            else if (y + Number(holdThing.length) > roomHeight) holdThing.coordY = roomHeight - Number(holdThing.length);
            else holdThing.coordY = y;
        }
    };

    $scope.free = function (thing) {
        holdThing = null;
        mouse.coordX = "";
        mouse.coordY = "";
        mouse.divX = "";
        mouse.divY = "";
    };

    $scope.getX = function () {
        return MouseCoords.getX(event);
    };

    $scope.getY = function () {
        return MouseCoords.getY(event)
    };

    $scope.checkingX = function (furniture) {
        if (furniture.width >= mainRoom.width) {
            furniture.width =  mainRoom.width;
        }
    };
    $scope.checkingY = function (furniture) {
        if (furniture.length >=  mainRoom.height) {
            furniture.length =  mainRoom.height;
        }
    };
    $scope.changeColor = function (furniture) {
        furniture.color = color;
    }
})
;
