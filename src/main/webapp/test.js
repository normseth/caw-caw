function stock(c,n) {
	this.code = c;
	this.name = n;
	this.text = n;
	this.done = false;
	return this;
}

function TodoCtrl($scope) {
	
    $scope.todos = [
                    {text:'learn angular', done:true},
                    {text:'build an angular app', done:false}];
	
	$.getJSON('http://localhost:8080/SimpleApp-1.0-SNAPSHOT/rest/stock/',function(data){
        console.log('success');
        $.each(data.employees,function(i,stock){
        	console.log(stock);
           stock s = stock(stock.stockCode, stock.stockName);
           $scope.todos.push(s);
        });
	});
	

     
    $scope.addTodo = function() {
	    $scope.todos.push({text:$scope.todoText, done:false});
	    $scope.todoText = '';
    };
     
    $scope.remaining = function() {
	    var count = 0;
	    angular.forEach($scope.todos, function(todo) {
		    count += todo.done ? 0 : 1;
		    });
	    return count;
	    };
		     
		$scope.archive = function() {
		    var oldTodos = $scope.todos;
		    $scope.todos = [];
		    angular.forEach(oldTodos, function(todo) {
		    if (!todo.done) $scope.todos.push(todo);
		});
	};
}