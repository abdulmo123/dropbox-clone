import { Box, Toolbar, Button, Grid, Dialog, DialogActions, DialogContent, DialogTitle, TextField, Stack } from "@mui/material";
import LeftPaneMenu from "../components/LeftPaneMenu";
import AddIcon from '@mui/icons-material/Add';
import UploadIcon from '@mui/icons-material/Upload';
import React from "react";

export default function Home() {
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSubmit = (event: { preventDefault: () => void; currentTarget: HTMLFormElement | undefined; }) => {
        event.preventDefault();
        const formData = new FormData(event.currentTarget);
        const formJson = Object.fromEntries(formData.entries());
        console.log('formJson', formJson);
        const email = formJson.email;
        console.log(email);
        handleClose();

        // TODO: do some backend call to create this folder
    };

    return (
        <>
            {/* <NavAppBar /> */}
            <Grid container spacing={2}>
                <Grid size={4}>
                    <Box sx={{ width: { xs: '100%', sm: '250px' }, bgcolor: 'grey.200' }}>
                        <LeftPaneMenu />
                    </Box>
                </Grid>
                <Grid size={8}>
                    <Box>
                        <Toolbar />
                        <Stack direction="row" spacing={1}>
                            <Button variant="outlined" startIcon={<AddIcon />} onClick={handleClickOpen}>
                                Create Folder
                            </Button>
                            <Button component="label" variant="outlined" startIcon={<UploadIcon />}>
                                <input type="file" hidden />
                                Upload File
                            </Button>
                        </Stack>
                    </Box>
                </Grid>
            </Grid>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Create New Folder</DialogTitle>
                <DialogContent>
                    <form onSubmit={handleSubmit} id="folder-form">
                        <TextField
                            autoFocus
                            required
                            margin="dense"
                            id="name"
                            name="name"
                            label="Folder name"
                            type="text"
                            fullWidth
                            variant="standard"
                        />
                    </form>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit" form="folder-form">
                        Create
                    </Button>
                </DialogActions>
            </Dialog>
        </>
    );
}