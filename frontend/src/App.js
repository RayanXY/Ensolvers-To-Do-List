import './css/App.css';
import React from 'react';
import axios from 'axios';
import Titles from './components/TItles';
import TodoList from './components/TodoList';
import AddTodoItem from './components/AddTodoItem';
import UpdateTodoItem from './components/UpdateTodoItem';

class App extends React.Component {

    state={
        list: [],
		showEdit: false,
		editTask: "",
    }

    getListFromBD() {
        axios.get("http://localhost:8080/tasks").then(response => response.data)
            .then((data) => {
                this.setState({ list: data });
            })
    }

    componentDidMount() {
        this.getListFromBD();
    }

	// SHOWS EDIT BLOCK
	showEditItem = (bool, task) => {
		this.setState({
			showEdit: bool,
			editTask: task
		});
	}
 
    // ADD NEW TASK
    addItem = (newTask) => {
		if(newTask === "") {
			return;
		}
        const item = {id: 0, description: newTask, done: 0};
        axios.post("http://localhost:8080/tasks", item)
             .then(res => {
                 this.getListFromBD();
             })
    }

	// UPDATE A TASK
	updateItem = (task, taskDescription) => {
		const item = {id: task.id, description: taskDescription, done: !task.done};
		axios.put("http://localhost:8080/tasks/", item)
        .then(res => {
			this.setState({
				showEdit: false,
			});
            this.getListFromBD();
        })
	}

	// DELETE A TASK
    deleteItem = (deleteTaskID) => {
        axios.delete(`http://localhost:8080/tasks/${deleteTaskID}`)
        .then(res => {
            this.getListFromBD();
        });
    }

    // MARK A TASK AS DONE
    doneItem = (updateTask) => {
        axios.put("http://localhost:8080/tasks/", updateTask)
        .then(res => {
            this.getListFromBD();
        })
    }

    render() {
        return(
			<div>
				<div className="ToDo_List">
					<Titles title="To-Do List" size={34} />
					<Titles title="Tasks" size={24} />   
					<TodoList list={this.state.list} deleteItem={this.deleteItem} doneItem={this.doneItem} showEditItem={this.showEditItem}/>
					<Titles title="Add task" size={24} />
					<AddTodoItem addItem={this.addItem} />
					
				</div>
				{this.state.showEdit && 
					<div className="ToDo_List" style={{ marginTop: "10px" }}>
							<Titles title={"Editing Task \"" + this.state.editTask.description + "\""} size={18}/>
							<UpdateTodoItem editItem={this.state.editTask} showEditItem={this.showEditItem} updateItem={this.updateItem} />
					</div>
				}
			</div>
        );
    }
    
}

export default App;
