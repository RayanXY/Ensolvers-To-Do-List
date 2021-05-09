import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

import EditIcon from '@material-ui/icons/Edit';
import DoneIcon from '@material-ui/icons/Done';
import DeleteIcon from '@material-ui/icons/Delete';
import IconButton from '@material-ui/core/IconButton';

class TodoItem extends React.Component {

    render (){
        const { task, deleteItem, doneItem, showEditItem } = this.props;

        return(
            <ListItem>
                
                <IconButton edge="start" onClick={() => doneItem(task)}>
                    <DoneIcon color={task.done ? "primary" : "secondary"}/>
                </IconButton>

                <ListItemText className={task.done ? "StruckLine" : "Titles"} primary={task.description} />

				<IconButton edge="end" onClick={() => showEditItem(true, task)}>
					<EditIcon color="primary" />
				</IconButton>

                <IconButton edge="end" onClick={() => deleteItem(task.id)}>
                    <DeleteIcon color="secondary" />
                </IconButton>

            </ListItem>
        );
    }
    
}

export default TodoItem;
