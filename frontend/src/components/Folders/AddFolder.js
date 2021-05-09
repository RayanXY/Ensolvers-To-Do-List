import React from 'react';
import SaveIcon from '@material-ui/icons/Save';
import TextField from '@material-ui/core/TextField';
import IconButton from '@material-ui/core/IconButton'

class AddFolder extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            folder: "",
        };
    }

    handleChange = (e) => {
        this.setState({
         	folder: e.target.value
        });
    }

    render () {
        const { addFolder } = this.props 

        return (
            <div className="Task">
                <TextField placeholder="New Folder" onChange={this.handleChange}/>
                <IconButton onClick={() => addFolder(this.state.folder)} >
                    <SaveIcon />
                </IconButton>
            </div>
        );
    }

}

export default AddFolder;
