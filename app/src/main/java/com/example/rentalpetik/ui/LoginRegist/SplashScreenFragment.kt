import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rentalpetik.R
import com.example.rentalpetik.ui.LoginRegist.LoginFragment
import com.example.rentalpetik.MainActivity

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cek status login dari SharedPreferences
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("MYPREF", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        // Delay 1 detik, lalu pindah ke fragment sesuai status login
        Handler(Looper.getMainLooper()).postDelayed({
            if (isLoggedIn) {
                // Jika sudah login, pindah ke MainActivity
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                requireActivity().finish() // Agar SplashScreen tidak bisa diakses lagi
            } else {
                // Jika belum login, pindah ke LoginFragment
                parentFragmentManager.beginTransaction().replace(R.id.containere, LoginFragment()).commit()
            }
        }, 1000) // 1000ms = 1 detik
    }
}
