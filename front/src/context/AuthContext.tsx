import React, { createContext, useContext, useEffect, useState } from 'react';
import { getCookie } from '../utils/cookies';

type AuthContextType = {
  isAuthenticated: boolean;
  userId: string | null;
  userName: string | null;
  isLoading: boolean;
  logout: () => void;
  checkAuth: () => void;
};

const AuthContext = createContext<AuthContextType>({
  isAuthenticated: false,
  userId: null,
  userName: null,
  isLoading: true,
  logout: () => {},
  checkAuth: () => {}
});

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [state, setState] = useState({
    userId: null as string | null,
    userName: null as string | null,
    isLoading: true
  });

  const checkAuth = () => {
    try {
      const id = getCookie('user_id');
      const token = getCookie('auth_token');
      const name = getCookie("user_name");

      setState({
        userId: id && token && name ? id : null,
        userName: name ?? null,
        isLoading: false
      });
    } catch (error) {
      console.error('Auth check failed:', error);
      setState(s => ({...s, isLoading: false}));
    }
  };

  useEffect(() => {
    console.log("initial auth check running")
    checkAuth();
  }, []);

  const logout = () => {
    document.cookie = 'auth_token=; Max-Age=0; path=/';
    document.cookie = 'user_id=; Max-Age=0; path=/';
    setState({ userId: null, userName: null, isLoading: false });
  };

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated: !!state.userId,
        userId: state.userId,
        userName: state.userName,
        isLoading: state.isLoading,
        logout,
        checkAuth
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
