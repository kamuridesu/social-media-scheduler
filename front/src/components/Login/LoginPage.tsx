import { useState, FormEvent } from "react";
import { useNavigate } from "react-router-dom";
import { setCookie } from "@/utils/cookies";
import { useAuth } from "@/context/AuthContext";
import { LoginInput } from "./LoginInput";


export default function LoginPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [isLoading, setIsLoading] = useState(false);
    const { checkAuth } = useAuth();
    const navigate = useNavigate();

    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();
        setIsLoading(true);

        try {
            const fakeAuthResponse = {
                token: "test_token",
                user: { id: "123", name: "ababa" }
            }

            setCookie("auth_token", fakeAuthResponse.token);
            setCookie("user_id", fakeAuthResponse.user.id)
            setCookie("user_name", fakeAuthResponse.user.name);

            await new Promise(resolve => setTimeout(resolve, 1000));
            checkAuth();
            navigate("/");
        } catch (err) {
            alert("Login failed: " + err);
        } finally {
            setIsLoading(false);
        }
    }

    return (
        <div className="min-h-screen bg-white flex flex-col items-center justify-center p-4">
            <header className="mb-8 text-center">
                <h1 className="text-4xl font-bold text-primary mb-2">
                    Shitpost Scheduler
                </h1>
            </header>

            <form
                onSubmit={handleSubmit}
                className="bg-gray-100 rounded-xl w-7xl max-w-md gap-x-7 justify-center text-center mx-auto p-6"
            >

                <LoginInput name="username" setProperty={setUsername} property={username} />
                <LoginInput name="password" setProperty={setPassword} property={password} isPassword />

                <div className="mt-6">
                    <button
                        type="submit"
                        disabled={isLoading || !username || !password}
                        className={`py-2 px-4 rounded-lg transition-colors ${isLoading || !username || !password
                            ? 'bg-gray-300 text-white cursor-not-allowed'
                            : 'bg-gray-500 text-white hover:bg-primary-dark'}`}
                    > {isLoading ? "Logging in..." : "Login"}</button>
                </div>
            </form>
        </div>
    )
}
