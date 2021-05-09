import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

import DeleteIcon from '@material-ui/icons/Delete';
import IconButton from '@material-ui/core/IconButton';

class FolderItem extends React.Component {

    render (){
        const { folder } = this.props;

        return(
            <ListItem>

                <ListItemText className="Titles" primary={folder.name} />

               	<IconButton edge="end">
                  	<p style={{ fontSize: "16px"}}>View Tasks</p>
               	</IconButton>

                <IconButton edge="end">
                    <DeleteIcon color="secondary" />
                </IconButton>

            </ListItem>
        );
    }
    
}

export default FolderItem;
