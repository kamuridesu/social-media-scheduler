import { Navigate, useLocation } from "react-router-dom";
import { useAuth } from "@/context/AuthContext";
import { JSX } from "react";
import LoadingSpinner from "./LoadingSpinner";

const ProtectedRoute = ({children}: {children: JSX.Element}) => {
    const { isAuthenticated, isLoading } = useAuth();
    const location = useLocation();

    if (isLoading) {
        console.log("is loading")
        return <LoadingSpinner/>;
    }

    if (!isAuthenticated) {
        return <Navigate to="/login" state={{ from: location }} replace />;
    }

    return children;
}

export default ProtectedRoute;
