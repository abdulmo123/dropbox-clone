import React from "react";
import {
    Avatar,
    Box,
    Container,
    Paper,
    TextField,
    Typography,
    Button,
    Grid,
    Link,
    InputAdornment,
    IconButton,
    CssBaseline,
} from "@mui/material";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import { Link as RouterLink } from "react-router-dom";
import { Visibility, VisibilityOff } from "@mui/icons-material";

export default function SignupPage() {
    const [showPassword, setShowPassword] = React.useState(false);
    const handleSubmit = () => console.log('signup');
    const handleClickShowPassword = () => setShowPassword((show) => !show);

    return (
        <Container maxWidth="xs">
            <CssBaseline />
            <Paper elevation={10} sx={{ marginTop: 8, padding: 2 }}>
                <Avatar
                    sx={{
                        mx: "auto",
                        bgcolor: "secondary.main",
                        textAlign: "center",
                        mb: 1,
                    }}
                >
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5" sx={{ textAlign: "center" }}>
                    Sign Up
                </Typography>
                <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
                    <TextField
                        placeholder="Enter first name"
                        fullWidth
                        label="First Name"
                        required
                        autoFocus
                        sx={{ mb: 2 }}
                    />
                    <TextField
                        placeholder="Enter last name"
                        fullWidth
                        label="Last Name"
                        required
                        autoFocus
                        sx={{ mb: 2 }}
                    />
                    <TextField
                        placeholder="Enter email"
                        fullWidth
                        label="Email"
                        required
                        autoFocus
                        sx={{ mb: 2 }}
                    />
                    <TextField
                        placeholder="Enter password"
                        fullWidth
                        label="Password"
                        required
                        type={showPassword ? 'text' : 'password'}
                        sx={{ mb: 2 }}
                        slotProps={{
                            input: {
                                endAdornment: (
                                    <InputAdornment position="end">
                                        <IconButton onClick={handleClickShowPassword} edge="end">
                                            {showPassword ? <VisibilityOff /> : <Visibility />}
                                        </IconButton>
                                    </InputAdornment>
                                )
                            }
                        }}
                    />
                    <TextField
                        placeholder="Re-enter password"
                        fullWidth
                        label="Re-enter Password"
                        required
                        type={showPassword ? 'text' : 'password'}
                        slotProps={{
                            input: {
                                endAdornment: (
                                    <InputAdornment position="end">
                                        <IconButton
                                            onClick={handleClickShowPassword}
                                            edge="end"
                                        >
                                            {showPassword ? <VisibilityOff /> : <Visibility />}
                                        </IconButton>
                                    </InputAdornment>
                                ),
                            },
                        }}
                    />
                    <Button type="submit" variant="contained" fullWidth sx={{ mt: 2 }}>
                        Sign In
                    </Button>
                </Box>
                <Grid
                    container
                    direction="row"
                    sx={{
                        justifyContent: "space-between",
                        alignItems: "center",
                        mt: 2
                    }}
                >
                    <Grid>
                        <Link component={RouterLink} to="/forgot">
                            Forgot password?
                        </Link>
                    </Grid>
                    <Grid>
                        <Link component={RouterLink} to="/register">
                            Sign Up
                        </Link>
                    </Grid>
                </Grid>
            </Paper>
        </Container>
    )
}