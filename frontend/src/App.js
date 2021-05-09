import './css/App.css';
import React from 'react';
import axios from 'axios';
import Titles from './components/Titles';
import FolderList from './components/Folders/FolderList';
import AddFolder from './components/Folders/AddFolder';

class App extends React.Component {

    state={
		folderList: [],
    }

	// FOLDERS API
	getFolderListFromBD() {
		axios.get("http://localhost:8080/folders").then(response => response.data)
            .then((data) => {
                this.setState({ folderList: data });
            });
	}

	// ADD NEW FOLDER
	addFolder = (newFolderName) => {
		if(newFolderName === "") {
			return;
		}
		const folder = {id: 0, name: newFolderName};
		axios.post("http://localhost:8080/folders", folder)
			.then(response => {
				this.getFolderListFromBD();
			});
	}

	// APP FUNCTIONS
	componentDidMount() {
        this.getFolderListFromBD();
    }

    render() {
        return(
			<div className="ToDo_List">
				<Titles title="Folders" size={34} />
				<FolderList folderList={this.state.folderList} />
				<Titles title="Create new folder" size={24} />
				<AddFolder addFolder={this.addFolder} />
			</div>
        );
    }
    
}

export default App;
