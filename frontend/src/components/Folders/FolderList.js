import React from 'react';
import List from '@material-ui/core/List';
import FolderItem from './FolderItem';

class FolderList extends React.Component {

    render() {
        const { folderList } = this.props  

        return (
            <List>
            {
                folderList.map( folder => {
                    return(
                        <FolderItem key={folder.id} folder={folder} />
                    )
                })
            }
            </List>
        );
    }
    
}

export default FolderList;
