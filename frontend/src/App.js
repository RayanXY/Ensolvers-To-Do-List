import './css/App.css';
import React from 'react';
import axios from 'axios';
import Titles from './components/TItles';
import TodoList from './components/TodoList';
import AddTodoItem from './components/AddTodoItem';

class App extends React.Component {

    state={
        list: []
    }

    getListFromBD(){
        axios.get("http://localhost:8080/tasks").then(response => response.data)
            .then((data) => {
                this.setState({ list: data });
            })
    }

    componentDidMount(){      
        this.getListFromBD();
    }
 
    // ADD NEW TASK
    addItem = (newTask) => {
        const item = {id: 0, description: newTask, done: 0};
        axios.post("http://localhost:8080/tasks", item)
             .then(res => {
                 this.getListFromBD();
             })
    }

	// DELETE A TASK
    deleteItem = (deleteTaskID) =>{
        axios.delete(`http://localhost:8080/tasks/${deleteTaskID}`)
        .then(res => {
            this.getListFromBD();
        });
    }

    // UPDATE A TASK
    doneItem = (updateTask) => {
        axios.put("http://localhost:8080/tasks/", updateTask)
        .then(res => {
            this.getListFromBD();
        })
    }

    render() {
        return(
            <div className="ToDo_List">
                <Titles title="To-Do List" size={34} />
                <Titles title="Tasks" size={24} />   
               	<TodoList list={this.state.list} deleteItem={this.deleteItem} doneItem={this.doneItem}/>
                <Titles title="Add task" size={24} />
                <AddTodoItem addItem={this.addItem} />
            </div>
        );
    }
    
}

export default App;
