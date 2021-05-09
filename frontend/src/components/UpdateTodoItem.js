import React from 'react';
import SaveIcon from '@material-ui/icons/Save';
import Input from '@material-ui/core/Input';
import IconButton from '@material-ui/core/IconButton'
import CloseIcon from '@material-ui/icons/Close';

class UpdateTodoItem extends React.Component {

   constructor(props){
        super(props);
        this.state = {
            editDescription: props.editItem.description,
        };
    }

    handleChange = (e) => {
        this.setState({
            editDescription: e.target.value
        });
    }

    render () {
        const { editItem, showEditItem, updateItem } = this.props;

        return (
            <div className="Task">
                <Input defaultValue={editItem.description} onChange={this.handleChange} />
                <IconButton>
                    <SaveIcon onClick={() => updateItem(editItem, this.state.editDescription)}/>
                </IconButton>
				<IconButton>
					<CloseIcon color="secondary" onClick={() => showEditItem(false, "")} />
				</IconButton>
            </div>
        );
    }

}

export default UpdateTodoItem;
