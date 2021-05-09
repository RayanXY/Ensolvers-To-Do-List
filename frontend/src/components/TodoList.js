import React from 'react';
import TodoItem from './TodoItem';
import List from '@material-ui/core/List';

class TodoList extends React.Component {

    render() {
        const { list, deleteItem, doneItem, showEditItem } = this.props  

        return (
            <List>
            {
                list.map( task => {
                    return(
                        <TodoItem key={task.id} task={task} deleteItem={deleteItem} doneItem={doneItem} showEditItem={showEditItem} />
                    )
                })
            }
            </List>
        );
    }
    
}

export default TodoList;
