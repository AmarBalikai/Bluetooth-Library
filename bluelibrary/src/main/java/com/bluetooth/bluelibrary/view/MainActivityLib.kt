package com.bluetooth.bluelibrary.view

import android.app.Fragment
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.bluetooth.bluelibrary.abstracts.BaseBluetoothActivity
import com.bluetooth.bluelibrary.utils.SimpleBluetoothListener
import com.example.bluelibrary.R

class MainActivityLib : BaseBluetoothActivity() {
    private var lytFrame: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lib_activity_main)
        lytFrame = findViewById<FrameLayout>(R.id.lytFrame)
        val mFragment: Fragment = AnimationFragment()
        val ft = fragmentManager.beginTransaction()
        ft.add(lytFrame!!.id, mFragment).commit()
    }
    override fun onBluetoothEnabled() {
        super.onBluetoothEnabled()
        //Toast.makeText(this, "BT Enabled", Toast.LENGTH_SHORT).show();
    }

    override fun onDeviceSelected(macAddress: String?, name: String?) {
        super.onDeviceSelected(macAddress, name)
        // Toast.makeText(this, "Device " + macAddress, Toast.LENGTH_SHORT).show();
    }
    override fun getSimpleBluetoothListener(): SimpleBluetoothListener {
        return object : SimpleBluetoothListener() {
            override fun onBluetoothDataReceived(bytes: ByteArray?, data: String) {
                super.onBluetoothDataReceived(bytes, data)
                Log.e("----------------", "Data........ $data")
                val intent = Intent()
                intent.putExtra("data", data)
                intent.putExtra(
                    "info",
                    bluetoothInfoModel.bluetoothName + "#" + bluetoothInfoModel.bluetoothMacAddress
                )
                setResult(RESULT_OK, intent)
                finish()
            }

            override fun onDeviceConnected(device: BluetoothDevice?) {
                super.onDeviceConnected(device)
            }

            override fun onDeviceDisconnected(device: BluetoothDevice?) {
                super.onDeviceDisconnected(device)
            }

            override fun onDiscoveryStarted() {
                super.onDiscoveryStarted()
            }

            override fun onDiscoveryFinished() {
                super.onDiscoveryFinished()
            }

            override fun onDevicePaired(device: BluetoothDevice?) {
                super.onDevicePaired(device)
            }

            override fun onDeviceUnpaired(device: BluetoothDevice?) {
                super.onDeviceUnpaired(device)
            }

            override fun onBluetoothNotInitialized() {
                super.onBluetoothNotInitialized()
                finish()
            }
        }
    }
}