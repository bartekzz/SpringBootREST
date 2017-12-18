/**
 * Created by Bartek 2017-12-07
 */

(function () {
    'use strict';

    angular
        .module('app')
        .controller('AngularController', AngularController);

    AngularController.$inject = ['$http'];

    function AngularController($http) {
        var vm = this;

        vm.users = [];
        vm.getAllUsers = getAllUsers;
        vm.getAllUsersByEmail = getAllUsersByEmail;
        vm.updateUserById = updateUserById;
        vm.insertUserById = insertUserById;
        vm.deleteUserById = deleteUserById;
        vm.toggle = toggle;
        vm.addNew = addNew;
        vm.disableInput = disableInput;
        vm.setLabel = setLabel;
        vm.isDisabled = [];
        vm.buttonLabel = [];

        init();;

        function init(){

            getAllUsers();
            angular.element(document).ready(function () {
                console.log('page loading completed');
                var countToggleButtons = document.querySelectorAll('.toggle').length;
                console.log('toggle count: ' + countToggleButtons);
                disableInput(countToggleButtons);
                setLabel();
            });
        }

        function disableInput(countToggleButtons) {
            console.log("Disabling input!");
            for (var i=0; i<5; i++) {
                console.log("Disabling .. " + i );
                vm.isDisabled[i] = true;
            }
        }

        function setLabel() {
            console.log("Setting button text!");
            for (var i=0; i<5; i++) {
                console.log("Setting label text .. " + i );
                vm.buttonLabel[i] = "Edit";
            }
        }

        function addNew() {
            vm.users.push({
                'id': "",
                'name': "",
                'email': "",
                'password': "",
                'key': ""
            });
        }

        function getAllUsers(){
            var url = "/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function getAllUsersByEmail(email){
            console.log("Email to send: " + email);
            var url = "/all/email/" + email.replace(".", "_");
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function insertUserById(user){
            var url = "/post-user";
            var bookingsPromise = $http.post(url, user);
            bookingsPromise.then(function(response){
                vm.users = response.data;
            });
        }


        function updateUserById(user){
            var url = "/put-user";
            var bookingsPromise = $http.put(url, user);
            bookingsPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function deleteUserById(id){
            var url = "/delete-user/" + id;
            $http.post(url).then(function(response){
                vm.users = response.data;
            });
        }

        function toggle(id, user) {

            console.log('Id value:' + id);

            if(vm.isDisabled[id]) {
                console.log('Making editable.');
                vm.isDisabled[id] = false;
                vm.buttonLabel[id] = "Save";
                console.log('Id:' + id + 'is: ' + vm.isDisabled[id]);
                console.log(vm.isDisabled[id]);
            } else {
                console.log('Saving data... and disabling');
                if(user.id != "") {
                    updateUserById(user);
                    console.log('User update: ' + user);
                } else {
                    insertUserById(user);
                    console.log('User insert: ' + user);
                }
                vm.isDisabled[id] = true;
                vm.buttonLabel[id] = "Edit";
                console.log(vm.isDisabled[id]);
            }

        }

    }
})();
